package com.gang.sdk.api.type;

import com.gang.sdk.api.annotation.SyncCreate;
import com.gang.sdk.api.annotation.SyncDelete;
import com.gang.sdk.api.annotation.SyncInit;
import com.gang.sdk.api.annotation.SyncSearch;
import com.gang.sdk.api.annotation.SyncUpdate;
import com.sun.corba.se.impl.orbutil.concurrent.Sync;

/**
 * @Classname SyncOperationType
 * @Description TODO
 * @Date 2019/12/28 20:01
 * @Created by zengzg
 */
public enum SyncOperationType {

    CREATE(SyncCreate.class, "CREATE"),
    UPDATE(SyncUpdate.class, "UPDATE"),
    DELETE(SyncDelete.class, "DELETE"),
    SEARCH(SyncSearch.class, "SEARCH"),
    INIT(SyncInit.class, "INIT");

    private Class clazzName;
    private String operationType;

    SyncOperationType(Class clazzName, String operationType) {
        this.clazzName = clazzName;
        this.operationType = operationType;
    }

    public Class getClazzName() {
        return clazzName;
    }

    public String getOperationType() {
        return operationType;
    }
}
