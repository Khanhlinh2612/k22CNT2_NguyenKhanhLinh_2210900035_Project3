package com.springmvc.enums;

import java.util.HashMap;
import java.util.Map;

public enum NklChucVu {
    NHAN_VIEN("Nhan vien"), // ✅ Sửa lại đúng với ENUM trong database (không dấu)
    QUAN_LY("Quan ly");

    private final String value;
    private static final Map<String, NklChucVu> lookup = new HashMap<>();

    static {
        for (NklChucVu chucVu : NklChucVu.values()) {
            lookup.put(chucVu.value.toLowerCase(), chucVu);
            lookup.put(chucVu.name().toLowerCase(), chucVu);
        }
    }

    NklChucVu(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static NklChucVu fromString(String text) {
        if (text == null || text.trim().isEmpty()) {
            return NHAN_VIEN;
        }
        return lookup.getOrDefault(text.trim().toLowerCase(), NHAN_VIEN);
    }
}
