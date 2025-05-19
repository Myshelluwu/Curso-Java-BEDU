abstract class UnidadEmergencia {
    protected String nombre;

    public UnidadEmergencia(String nombre) {
        this.nombre = nombre;
    }

    public abstract void responder();

    public void activarUnidad() {
        System.out.println("Activando unidad: " + nombre);
    }
}

class SistemaGPS {
    public void localizar() {
        System.out.println("GPS: Ubicación actual detectada.");
    }
}

class Sirena {
    public void activarSirena() {
        System.out.println("Sirena: Activada.");
    }
}

class Operador {
    private String nombre;

    public Operador(String nombre) {
        this.nombre = nombre;
    }

    public void reportarse() {
        System.out.println("Operador " + nombre + " reportándose.");
    }
}

class Ambulancia extends UnidadEmergencia {
    private SistemaGPS gps;
    private Sirena sirena;
    private Operador operador;

    public Ambulancia(String nombre, String nombreOperador) {
        super(nombre);
        this.gps = new SistemaGPS();
        this.sirena = new Sirena();
        this.operador = new Operador(nombreOperador);
    }

    @Override
    public void responder() {
        System.out.println("Ambulancia en camino al hospital más cercano.");
    }

    public void iniciarOperacion() {
        activarUnidad();
        gps.localizar();
        sirena.activarSirena();
        operador.reportarse();
        responder();
    }
}

class Patrulla extends UnidadEmergencia {
    private SistemaGPS gps;
    private Sirena sirena;
    private Operador operador;

    public Patrulla(String nombre, String nombreOperador) {
        super(nombre);
        this.gps = new SistemaGPS();
        this.sirena = new Sirena();
        this.operador = new Operador(nombreOperador);
    }

    @Override
    public void responder() {
        System.out.println("Patrulla atendiendo situación de seguridad ciudadana.");
    }

    public void iniciarOperacion() {
        activarUnidad();
        gps.localizar();
        sirena.activarSirena();
        operador.reportarse();
        responder();
    }
}

class UnidadBomberos extends UnidadEmergencia {
    private SistemaGPS gps;
    private Sirena sirena;
    private Operador operador;

    public UnidadBomberos(String nombre, String nombreOperador) {
        super(nombre);
        this.gps = new SistemaGPS();
        this.sirena = new Sirena();
        this.operador = new Operador(nombreOperador);
    }

    @Override
    public void responder() {
        System.out.println("Unidad de bomberos respondiendo a incendio estructural.");
    }

    public void iniciarOperacion() {
        activarUnidad();
        gps.localizar();
        sirena.activarSirena();
        operador.reportarse();
        responder();
    }
}

