package com.nl.nexusblast.watermark;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;

public class Watermark {
    Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
    Table watermarkTable = new Table();
 public Watermark(){
     watermarkTable.setFillParent(true);
     watermarkTable.add(new Label("NEXUSBLAST CODENAME: POLYBIUS V0.0.0", skin));
     watermarkTable.align(Align.bottom | Align.right);
 }

    public Table getWatermark(){
        return watermarkTable;
    }
}
