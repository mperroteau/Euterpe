/*===============================================================================================
 Offline Decoding Example
 Copyright (c), Firelight Technologies Pty, Ltd 2004-2005.

 This example shows how decode a file to PCM, without playing it.
 It writes out the data as a raw data file.
 The System::createSound function uses FMOD_OPENONLY so that FMOD does not read any data 
 itself.
 If this is uses then it is up to the user to use Sound::readData to get the data out of 
 the file and into the destination buffer.
===============================================================================================*/
#include "../../api/inc/fmod.hpp"
#include "../../api/inc/fmod_errors.h"
#include <windows.h>
#include <stdio.h>
#include <conio.h>

unsigned char	*gpMusic;
int gMusicSize=0,counter=0;
unsigned int g_lengthRaw;

void ERRCHECK(FMOD_RESULT result)
{
    if (result != FMOD_OK)
    {
        printf("FMOD error! (%d) %s\n", result, FMOD_ErrorString(result));
        exit(-1);
    }
}

FMOD_RESULT F_CALLBACK myopen(const char *name, int unicode, unsigned int *filesize, void **handle, void **userdata)
{
	char* tmpName=(char*)malloc(2);
	*userdata=itoa(counter++,tmpName,2);;

	printf("myopen %s\n",*userdata);
	return FMOD_OK;
}

FMOD_RESULT F_CALLBACK myclose(void *handle, void *userdata){
	printf("myclose %s\n",userdata);
	return FMOD_OK;
}

FMOD_RESULT F_CALLBACK myread(void *handle, void *buffer, unsigned int sizebytes, unsigned int *bytesread, void *userdata){
	//printf("myread\n");
	if (g_lengthRaw < sizebytes + gMusicSize){
		gpMusic=(unsigned char*)realloc(gpMusic,sizebytes + gMusicSize);
	}
	memcpy( gpMusic + gMusicSize, (unsigned char*)buffer, sizebytes );
	gMusicSize += sizebytes;

	return FMOD_OK;
}

int main(int argc, char *argv[])
{
    FMOD::System     *system,*system2;
	FMOD::Channel    *channel=NULL;
    FMOD::Sound      *sound,*sound2=NULL;
    FMOD_RESULT       result;
    unsigned int      version;
	bool isplaying;

	FMOD_CREATESOUNDEXINFO m_exinfoMusictrack;
	memset(&m_exinfoMusictrack, 0, sizeof(FMOD_CREATESOUNDEXINFO));
    /*
        Create a System object and initialize.
    */
    result = FMOD::System_Create(&system);
    ERRCHECK(result);

    result = FMOD::System_Create(&system2);
    ERRCHECK(result);

    result = system->getVersion(&version);
    ERRCHECK(result);

    if (version < FMOD_VERSION)
    {
        printf("Error!  You are using an old version of FMOD %08x.  This program requires %08x\n", version, FMOD_VERSION);
        return 0;
    }


    result = system->init(1, FMOD_INIT_NORMAL, 0);
    ERRCHECK(result);

    result = system2->init(1, FMOD_INIT_NORMAL, 0);
    ERRCHECK(result);

	result = system->attachFileSystem(myopen, myclose, myread, 0);

	gpMusic = (unsigned char*)malloc(300000);

    //result = system->createStream("hifi.m3u", FMOD_OPENONLY | FMOD_ACCURATETIME, 0, &sound);
    ERRCHECK(result);

    printf("===============================================================================\n");
    printf("Offline Decoding Example.  Copyright (c) Firelight Technologies 2004-2005.\n");
    printf("===============================================================================\n");
    printf("\n");
    printf("This program will open wave.mp3 and decode it into wave.raw using the\n");
    printf("Sound::readData function.\n");
    printf("\n");

    result = system->createStream("http://web.media.mit.edu/~assaf/ws.mp3", FMOD_OPENONLY | FMOD_ACCURATETIME, 0, &sound);

    /*
        Decode the sound and write it to a .raw file.
    */
    {
        void *data;
        unsigned int length = 0,read;
        unsigned int bytesread;
        FILE *outfp;

	    result = sound->getLength(&g_lengthRaw, FMOD_TIMEUNIT_RAWBYTES);
//		lengthRaw+=100000;
		m_exinfoMusictrack.cbsize = sizeof(FMOD_CREATESOUNDEXINFO);
		m_exinfoMusictrack.length = g_lengthRaw;
		gpMusic = (unsigned char*)realloc(gpMusic,g_lengthRaw);

        result = sound->getLength(&length, FMOD_TIMEUNIT_PCMBYTES);

        #define CHUNKSIZE 4096

        ERRCHECK(result);

        outfp = fopen("output.raw", "wb");
        if (!outfp)
        {
            printf("Error!  Could not open output.raw output file.\n");
            return 0;
        }

        data = malloc(CHUNKSIZE);
        if (!data)
        {
            printf("Error!  Failed to allocate %d bytes.\n", CHUNKSIZE);
            return 0;
        }

        bytesread = 0;
        do
        {
            result = sound->readData((char *)data, CHUNKSIZE, &read);

            fwrite((char *)data, read, 1, outfp);
            if (bytesread > 100000 && sound2==NULL){
				result = system2->createSound((const char*)gpMusic, (FMOD_MODE)(FMOD_SOFTWARE | FMOD_OPENMEMORY | FMOD_CREATESTREAM ), 
						&m_exinfoMusictrack, &sound2);
				//system2->playSound(FMOD_CHANNEL_FREE,sound2,0,&channel);
				ERRCHECK(result);
			}
			bytesread += read;
            //printf("writing %d bytes of %d to output.raw\r", bytesread, length);
			
			channel->isPlaying(&isplaying);
        }
        while ((result == FMOD_OK && read == CHUNKSIZE) ||  isplaying);

        /*
            Loop terminates when either 
            1. the read function returns an error.  (ie FMOD_ERR_FILE_EOF etc).
            2. the amount requested was different to the amount returned. (somehow got an EOF without the file error, maybe a non stream file format like mod/s3m/xm/it/midi).

            If 'bytesread' is bigger than 'length' then it just means that FMOD miscalculated the size, 
            but this will not usually happen if FMOD_ACCURATETIME is used.  (this will give the correct length for VBR formats)
        */

        printf("\n");

        if (outfp)
        {
            fclose(outfp);
        }
    }
        

    printf("\n");

    /*
        Shut down
    */
    result = sound->release();
    ERRCHECK(result);
	result = sound2->release();
    ERRCHECK(result);
	
    result = system->close();
    ERRCHECK(result);
    result = system->release();
    ERRCHECK(result);
    result = system2->close();
    ERRCHECK(result);
    result = system2->release();
    ERRCHECK(result);

    return 0;
}