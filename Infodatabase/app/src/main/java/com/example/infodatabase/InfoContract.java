package com.example.infodatabase;

import android.provider.BaseColumns;

public class InfoContract {

    public static final class InfoListEntry implements BaseColumns {
        public static final String TABLE_NAME = "information";
        public static final String NAME = "name";
        public static final String ADDRESS = "address";
        public static final String PHONE = "phone";
    }
}
