package pintura;

import java.text.DecimalFormat;

public class Cone {
    DecimalFormat df = new DecimalFormat("##,###.00");
    
    private float altura;
    private float raio;
    private int tinta;

    public double precolatatinta1 = 238.90;
    public double precolatatinta2 = 467.98;
    public double precolatatinta3 = 758.34;

    public Cone(float altura, float raio, int tinta) {
        setAltura(altura);
        setRaio(raio);
        setTinta(tinta);

    }

    public Cone(float altura, float raio) {
        setAltura(altura);
        setRaio(raio);
    }

    public Cone(int tinta) {
        setTinta(tinta);

    }

    public Cone() {
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura > 0) {
            this.altura = altura;
        }
    }

    public float getRaio() {
        return raio;
    }

    public void setRaio(float raio) {
        if (raio > 0) {
            this.raio = raio;
        }
    }

    public int getTinta() {
        return tinta;
    }

    public void setTinta(int tinta) {
        if (tinta > 0 && tinta < 3) {
            this.tinta = tinta;
        }
    }

    public float geratriz() {
        return ((raio * raio) + (altura * altura));
    }

    public float geratriz1() {
        return (float) Math.sqrt(geratriz());
    }

    public float areatotal() {
        return (float) (3.14 * raio * (raio + geratriz1()));
    }

    public float fundocone() {
        return (float) (3.14 * (raio * raio));
    }

    public float lateralcone() {
        return (float) (3.14 * raio * geratriz());
    }

    public float cobertura() {
        return (float) (1 / 3.45);
    }

    public float quantlitrostinta() {
        return (areatotal() / cobertura());
    }

    public int latastotal() {
        return (int) Math.ceil((quantlitrostinta() / 18));

    }

    public double precodalata() {
        switch (tinta) {
            case 1:
                return (precolatatinta1);
            case 2:
                return (precolatatinta2);
            case 3:
                return (precolatatinta3);
            default:
                return -1;
        }
    }

    public float valortotal() {
        return (float) (latastotal() * precodalata());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cone{");
        sb.append("altura=").append(altura);
        sb.append(", raio=").append(raio);
        sb.append(", tinta=").append(tinta);
        sb.append(", precolatatinta1=").append(precolatatinta1);
        sb.append(", precolatatinta2=").append(precolatatinta2);
        sb.append(", precolatatinta3=").append(precolatatinta3);
        sb.append('}');
        return sb.toString();
    }

    public String resultado() {
        StringBuilder sb = new StringBuilder();
        sb.append("Altura= ").append(altura);
        sb.append("\nRaio= ").append(raio);
        sb.append("\nGeratriz= ").append(geratriz1());
        sb.append("\nArea Total= ").append(areatotal());
        sb.append("\nFundo Cone= ").append(fundocone());
        sb.append("\nLateral Cone= ").append(lateralcone());
        sb.append("\nLitros Tinta= ").append(quantlitrostinta());
        sb.append("\nLatas Total= ").append(latastotal());
        sb.append("\nValor Total= ").append(df.format(valortotal())).append(" R$");
        return sb.toString();
    }

}
