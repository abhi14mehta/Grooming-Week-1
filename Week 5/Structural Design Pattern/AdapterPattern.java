

class Volts{
    int volt;
    Volts(int volt){
        this.volt=volt;
    }
    int getVolt(){
        return this.volt;
    }
    void setVolt(int volt){
        this.volt=volt;
    }
}

class Socket{
    public Volts getVolt(){
        return new Volts(120);
    }
}

interface Adapter{
    public Volts getVolt120();
    public Volts getVolt12();
    public Volts getVolt30();
}

class AdapterImpl extends Socket implements Adapter{
    @Override
    public Volts getVolt120(){
        return getVolt();
    }

    @Override
    public Volts getVolt12(){
        Volts v = getVolt();
        return convertVolts(v,10);
    }
    
    @Override
    public Volts getVolt30(){
        Volts v = getVolt();
        return convertVolts(v, 4);
    }

    private Volts convertVolts(Volts v, int i ){
        return new Volts(v.getVolt()/i);
    }
}

public class AdapterPattern {
    public static void main(String[] args) {
        Adapter adapter = new AdapterImpl();
		Volts volt30 = getVolt(adapter,30);
		Volts volt12 = getVolt(adapter,12);
		Volts volt120 = getVolt(adapter,120);
		System.out.println("volt30 volts using Class Adapter="+volt30.getVolt());
		System.out.println("volt12 volts using Class Adapter="+volt12.getVolt());
		System.out.println("volt120 volts using Class Adapter="+volt120.getVolt());
    }    
    private static Volts getVolt(Adapter adapter, int i) {
		switch (i){
		case 30: return adapter.getVolt30();
		case 12: return adapter.getVolt12();
		case 120: return adapter.getVolt120();
		default: return adapter.getVolt120();
		}
	}
}
