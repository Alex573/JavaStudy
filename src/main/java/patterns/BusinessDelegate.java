package patterns;

public class BusinessDelegate {
    public static void main(String[] args) {
        BusinsesDelegate businsesDelegate = new BusinsesDelegate();
        businsesDelegate.doTask("ejb");
    }
}

interface BussinesServ {
    void doJob();
}

class EJBService implements BussinesServ {

    @Override
    public void doJob() {
        System.out.println("EJB");
    }
}

class JMSService implements BussinesServ {

    @Override
    public void doJob() {
        System.out.println("JMS");
    }
}

class LookupService {
    BussinesServ getService(String serviceType) {
        if (serviceType.equals("ejb")) {
            return new EJBService();
        } else {
            return new JMSService();
        }
    }
}

class BusinsesDelegate {
    LookupService lookupService = new LookupService();
    BussinesServ bussinesServ;
    void  doTask(String serviceType){
        bussinesServ = lookupService.getService(serviceType);
        bussinesServ.doJob();
    }
}