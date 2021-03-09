package se.lexicon.jpaassignment.entity;

public enum Measurement {

    TSP(1), TBSP(2), ML(3), CL(4), DL(5), L(6),
    G(7), HG(8), KG(9), NON_BINARY(10);

    private int typeCode;

    Measurement(int typeCode){
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }
}
