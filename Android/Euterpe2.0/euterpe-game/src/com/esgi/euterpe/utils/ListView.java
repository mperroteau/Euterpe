package com.esgi.euterpe.utils;


import java.util.ArrayList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;

public class ListView extends List {

    private Rectangle cullingArea;
    private float padding = 5.0f;
    private float itemHeight;
    private Color dividerColor;
    private int dividerHeight;
    private TextureRegion line;
    private ArrayList<TextButton> textButtons = new ArrayList<TextButton>();

    private OnItemClickListener mOnItemClickListener;

    public ListView(Object[] items, ListStyle style, TextButton button,
                    Color color, int dividerHeight) {
        super(items, style);
        if (button != null) {
            textButtons.add(button);
        }
        this.dividerColor = color;
        this.dividerHeight = dividerHeight;
        float buttonHeight = button != null ? button.getHeight() : 0;
        itemHeight = getPrefHeight() / getItems().length;
        if (buttonHeight == 0) {
            buttonHeight = itemHeight;
        }
        style.selection.setTopHeight((buttonHeight - itemHeight) / 2 + padding);
        style.selection.setBottomHeight((buttonHeight - itemHeight) / 2
                + dividerHeight + padding);
        setStyle(style);
        itemHeight = getPrefHeight() / getItems().length;
        Pixmap pixmap = new Pixmap(512, 512, Pixmap.Format.RGBA8888);
        pixmap.setColor(dividerColor);
        pixmap.fillRectangle(0, 0, 512, dividerHeight);
        Texture texture = new Texture(pixmap);
        pixmap.dispose();
        line = new TextureRegion(texture, 512, dividerHeight);
        this.getListeners().removeIndex(0);
        addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (mOnItemClickListener != null) {
                    int index = getItems().length - (int) (y / itemHeight) - 1;
                    setSelectedIndex(index);
                    mOnItemClickListener.onItemClick(ListView.this, index,
                            getSelection());
                }
            }
        });
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        final float x = getX();
        final float y = getY();
        float itemY = getHeight();
        TextButton button = null;
        removeAllButton();
        for (int i = 0; i < getItems().length; i++) {
            if (cullingArea == null
                    || (itemY - itemHeight <= cullingArea.y
                    + cullingArea.height && itemY >= cullingArea.y)) {
                batch.draw(line, x, itemY + y - dividerHeight - itemHeight);

                if (textButtons.size() > 0) {
                    if (i < textButtons.size()) {
                        button = textButtons.get(i);
                    } else {
                        TextButton previous = textButtons.get(i - 1);
                        button = new TextButton(previous.getText().toString(),
                                previous.getStyle());
                        button.setBounds(previous.getX(), previous.getY(),
                                previous.getWidth(), previous.getHeight());
                        button.setBackground(previous.getBackground());
                        button.addListener(previous.getListeners().get(1));
                        textButtons.add(button);
                    }
                    this.getStage().addActor(button);
                    button.setX(Gdx.graphics.getWidth() - button.getWidth()
                            - padding);
                    button.setY(itemY + y - itemHeight + padding);
                    button.draw(batch, parentAlpha);
                }
            } else if (itemY < cullingArea.y) {
                break;
            }
            itemY -= itemHeight;
        }
    }

    private void removeAllButton() {
        Array<Actor> actors = this.getStage().getActors();
        for (TextButton button : textButtons) {
            actors.removeValue(button, true);
        }
    }

    public void setCullingArea(Rectangle cullingArea) {
        super.setCullingArea(cullingArea);
        this.cullingArea = cullingArea;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;

    }

    public static interface OnItemClickListener {
        void onItemClick(ListView listView, int index, String item);
    }

}