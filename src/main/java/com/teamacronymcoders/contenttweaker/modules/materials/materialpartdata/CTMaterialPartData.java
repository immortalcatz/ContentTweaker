package com.teamacronymcoders.contenttweaker.modules.materials.materialpartdata;

import com.teamacronymcoders.base.materialsystem.materialparts.MaterialPartData;

public class CTMaterialPartData implements IMaterialPartData {
    private MaterialPartData materialPartData;

    public CTMaterialPartData(MaterialPartData materialPartData) {
        this.materialPartData = materialPartData;
    }

    @Override
    public void addDataValue(String name, String value) {
        this.materialPartData.addDataValue(name, value);
    }
}
