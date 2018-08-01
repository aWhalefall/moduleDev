package com.component.model;

import com.acmenxd.retrofit.HttpDataEntity;
import com.component.model.db.ATypeListEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weichyang on 2018/2/27.
 */

public class NoteBookEntity extends HttpDataEntity {

    public List<ATypeListEntity> list = new ArrayList<>();

}
