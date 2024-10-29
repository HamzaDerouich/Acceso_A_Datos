package ficherosJson.ejercicios.Ej46;

class Origen {
	
    private String pais;
    private String region;

    public Origen() {}

    public Origen(String pais, String region) {
        this.pais = pais;
        this.region = region;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

	@Override
	public String toString() {
		return "Origen [pais=" + pais + ", region=" + region + "]";
	}
    
    
}
