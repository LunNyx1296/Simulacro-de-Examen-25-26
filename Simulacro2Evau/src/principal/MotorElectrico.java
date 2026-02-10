package principal;

import java.time.Year;

public class MotorElectrico extends Motor {

    private int voltaje;

    public MotorElectrico(String id, String marca, int voltaje) {
        super(id, marca);
        this.voltaje = voltaje;
    }

    @Override
    public double calcularCosteBase() {
        double coste = 200;
        int anyos = Year.now().getValue() - 2020;

        for (int i = 0; i < anyos; i++) {
            coste *= 1.015;
        }
        return coste;
    }
}