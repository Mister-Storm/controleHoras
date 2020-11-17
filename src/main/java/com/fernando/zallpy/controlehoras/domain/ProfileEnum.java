package com.fernando.zallpy.controlehoras.domain;

public enum ProfileEnum {

    ADMIN(1, "ROLE_ADMIN"),
    PROGRAMMER(2, "ROLE_PROGRAMMER");

    private int cod;
    private String description;

    ProfileEnum(int cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public int getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

    public static ProfileEnum toEnum(Integer cod) {

        if (cod == null) {
            return null;
        }

        for (ProfileEnum profileEnum : ProfileEnum.values()) {
            if (cod.equals(profileEnum.getCod())) {
                return profileEnum;
            }
        }

        throw new IllegalArgumentException("Invalid Id: " + cod);
    }
}
