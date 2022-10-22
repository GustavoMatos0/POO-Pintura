package pintura;

import java.text.DecimalFormat;

public class Cubo {
    DecimalFormat df = new DecimalFormat("#,##0.00");
    private double lado;
    private double rendimento;
    private int tinta;

    private double precolatatinta1 = 101.90;
    private double precolatatinta2 = 212.45;
    private double precolatatinta3 = 345.56;

    public Cubo(double lado, double rendimento, int tinta) {
        this.lado = lado;
        this.rendimento = rendimento;
        this.tinta = tinta;
    }

    public Cubo(double lado, double rendimento) {
        this.lado = lado;
        this.rendimento = rendimento;
    }

    public Cubo(double lado) {
        this.lado = lado;
    }

    public Cubo() {
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double lado) {
        if (lado > 0) {
            this.lado = lado;
        }
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        if (rendimento > 0) {
            this.rendimento = rendimento;
        }
    }

    public int getTinta() {
        return tinta;
    }

    public void setTinta(int tinta) {
        if (tinta > 0 && tinta <= 3) {
            this.tinta = tinta;
        }
    }

    public double getPrecolatatinta1() {
        return precolatatinta1;
    }

    public void setPrecolatatinta1(double precolatatinta1) {
        this.precolatatinta1 = precolatatinta1;
    }

    public double getPrecolatatinta2() {
        return precolatatinta2;
    }

    public void setPrecolatatinta2(double precolatatinta2) {
        this.precolatatinta2 = precolatatinta2;
    }

    public double getPrecolatatinta3() {
        return precolatatinta3;
    }

    public void setPrecolatatinta3(double precolatatinta3) {
        this.precolatatinta3 = precolatatinta3;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cubo{");
        sb.append("lado=").append(lado);
        sb.append(", rendimento=").append(rendimento);
        sb.append(", tinta=").append(tinta);
        sb.append(", areaBase()=").append(areaBase());
        sb.append(", areaTotal()=").append(areaTotal());
        sb.append(", volume()=").append(volume());
        sb.append(", diagonal()=").append(diagonal());
        sb.append(", litros()=").append(litros());
        sb.append(", latastotal()=").append(latastotal());
        sb.append(", precodalata()=").append(precodalata());
        sb.append(", valortotal()=").append(df.format(valortotal())).append(" R$");
        sb.append(", precolatatinta1=").append(precolatatinta1);
        sb.append(", precolatatinta2=").append(precolatatinta2);
        sb.append(", precolatatinta3=").append(precolatatinta3);
        sb.append('}');
        return sb.toString();
    }

    public double areaBase() {
        return lado * lado;
    }

    public double areaTotal() {
        return Math.pow(lado, 2) * 6;
    }

    public double volume() {
        return Math.pow(lado, 3);
    }

    public double diagonal() {
        return lado * Math.sqrt(3);
    }

    public double litros() {
        return areaTotal() / rendimento;
    }

    public int latastotal() {
        return (int) Math.ceil((litros() / 18));
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
}
