package se.lexicon.jpaassignment.entity;

public enum Measurement {

    TSP("tsp"), TBSP("tbsp"), ML("ml"), CL("cl"), DL("dl"), L("l"),
    G("g"), HG("hg"), KG("kg"), NON_BINARY("non_binary");

    private String typeCode;

    Measurement(String typeCode){
        this.typeCode = typeCode;
    }

    public String getTypeCode() {
        return typeCode;
    }

}
