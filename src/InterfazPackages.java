import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class InterfazPackages extends JFrame {
    private JPanel panelPrincipal;
    private JTabbedPane tabbedPaneCrearPackages;
    private JPanel JpanelCrearPackages;
    private JPanel JpanelRemover;
    private JPanel JpanelMostrar;
    private JPanel JpanelQuemar;
    private JPanel JpanelBuscar;
    private JTextField textFieldTrackingNumbre;
    private JTextField textFieldSAstreet;
    private JTextField textFieldSAcity;
    private JTextField textFieldSAstate;
    private JTextField textFieldSAzipCode;
    private JTextField textFieldRAstreet;
    private JTextField textFieldRAcity;
    private JTextField textFieldRAstate;
    private JTextField textFieldRAzipCode;
    private JTextField textFieldAnio;
    private JTextField textFieldMes;
    private JTextField textFieldDia;
    private JButton buttonCrearPackage;
    private JTextField textFieldIngreseTrackingN;
    private JButton ButtonRemover;
    private JTextArea textAreaMostrarPackageRemove;
    private JButton Buttonmostrar;
    private JTextArea textAreaMostrarPacketes;
    private JButton quemarDatosButton;
    private JTextArea textAreaMostraraDatosQuemados;
    private JTabbedPane tabbedPane1;
    private JTextField textFieldBuscarPorDestinatarioStreet;
    private JButton BuscarDD;
    private JTextPane textPaneDd;
    private JTextField textFieldBuscarPorTrackingNumber;
    private JButton buttonBuscarTr;
    private JTextArea textAreaTr;
    private JTextField textFieldAddrStreet;
    private JButton buttonBuscarAddr;
    private JTextArea textAreaAddr;
    private JTextField textFieldBuscarPorDestinatarioCity;
    private JTextField textFieldBuscarPorDestinatarioState;
    private JTextField textFieldBuscarPorDestinatarioZipCode;
    private JTextField textFieldAddrCity;
    private JTextField textFieldAddrState;
    private JTextField textFieldAddrZipCode;
    private JTextArea textAreaDD;
    private JTextField textFieldIngreseCiudad;
    private JTextArea textAreaIngreseCiudad;
    private JButton buttonBuscarPorCiudades;
    private JButton burbujaButton;
    private JButton inserccionButton;
    private JTextArea textAreaBurbuja;
    private JTextArea textAreaInserccion;
    Address addressNewSender,addressNewRecipter;
    Package packageNew;
    TrackingSystem trackingSystemNew =new TrackingSystem();

    Package packageA=new Package("004",new Address("KENNEDY","QUITO","Tungurahua","593"),new Address("MORLAN","GUAYAS","MACHALA","593"),LocalDate.of(2023,5,12));
    Package packageB=new Package("005",new Address("SOLCA","QUITO","Ambato","5934"),new Address("MONUMENTAL","MACHALA","MACHALA","593"),LocalDate.of(2023,5,12));
    Package packageC=new Package("006",new Address("GUAYACANES","QUITO","Imbabura","593456"),new Address("QUINTANA","MANTA","MACHALA","593"),LocalDate.of(2023,5,12));
    Package packageD=new Package("001",new Address("ELOY","QUITO","Oriente","5934567"),new Address("CHOCO","ESMERALDAS","ESMERALDAS","593"),LocalDate.of(2023,5,12));
    Package packageE=new Package("002",new Address("ALFARO","QUITO","PICHINCHA","5934568"),new Address("SALINAS","GUAYAS","NOSE","593"),LocalDate.of(2023,5,12));
    Package packageF=new Package("003",new Address("PRENSA","QUITO","LagoAgrio","59389"),new Address("UDLA","QUITO","MACHALA","593"),LocalDate.of(2023,5,12));

    public InterfazPackages() {
    add(panelPrincipal);
    setSize(300,200);
    setLocationRelativeTo(null);

    setTitle("Busqueda Binaria y Lineal");

    buttonCrearPackage.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
             addressNewSender=new Address(textFieldSAstreet.getText(),textFieldSAcity.getText(),textFieldSAstate.getText(),textFieldSAzipCode.getText());
             addressNewRecipter=new Address(textFieldRAstreet.getText(),textFieldRAcity.getText(),textFieldRAstate.getText(),textFieldRAzipCode.getText());
             LocalDate estimatedDeliveryDate= LocalDate.of(Integer.valueOf(textFieldAnio.getText()),Integer.valueOf(textFieldMes.getText()),Integer.valueOf(textFieldDia.getText()));
             packageNew= new Package(textFieldTrackingNumbre.getText(),addressNewSender,addressNewRecipter,estimatedDeliveryDate);
             trackingSystemNew.addPackage(packageNew);
        }
    });
        ButtonRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String TrackingNu=textFieldIngreseTrackingN.getText();
                trackingSystemNew.removePackage(trackingSystemNew.packages,TrackingNu);
                textAreaMostrarPackageRemove.setText("Se ha remivido Exitosamente el paquete "+TrackingNu);
            }
        });
        Buttonmostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaMostrarPacketes.setText(trackingSystemNew.packages.toString());
            }
        });
        quemarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackingSystemNew.addPackage(packageA);
                trackingSystemNew.addPackage(packageB);
                trackingSystemNew.addPackage(packageC);
                trackingSystemNew.addPackage(packageD);
                trackingSystemNew.addPackage(packageE);
                trackingSystemNew.addPackage(packageF);
                textAreaMostraraDatosQuemados.setText("Se han quemado los datos\n"+trackingSystemNew.packages.toString());
            }
        });
        BuscarDD.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Address recipientAddr=new Address(textFieldBuscarPorDestinatarioStreet.getText(),textFieldBuscarPorDestinatarioCity.getText(),textFieldBuscarPorDestinatarioState.getText(),textFieldBuscarPorDestinatarioZipCode.getText());
                textAreaDD.setText(" "+trackingSystemNew.searchByRecipientAddress(trackingSystemNew.packages,recipientAddr).toString());
            }
        });
        buttonBuscarTr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //trackingSystemNew.searchBinary(trackingSystemNew.packages,Integer.valueOf(textFieldBuscarPorTrackingNumber.getText()));
                //textAreaTr.setText(" "+trackingSystemNew.packages.get(trackingSystemNew.searchByTrackingNumberLineal(trackingSystemNew.packages,textFieldBuscarPorTrackingNumber.getText())).toString());
                textAreaTr.setText(" "+trackingSystemNew.searchBinary(trackingSystemNew.packages, Integer.valueOf(textFieldBuscarPorTrackingNumber.getText())).toString());
            }
        });
        buttonBuscarAddr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Address addressAddr=new Address(textFieldAddrStreet.getText(),textFieldAddrCity.getText(),textFieldAddrState.getText(),textFieldAddrZipCode.getText());
                textAreaAddr.setText(" "+trackingSystemNew.searchByAddress(trackingSystemNew.packages,addressAddr).toString());
            }
        });
        buttonBuscarPorCiudades.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textAreaIngreseCiudad.setText(" "+trackingSystemNew.searchByCity(trackingSystemNew.packages,textFieldIngreseCiudad.getText()).toString());
                System.out.println(trackingSystemNew.searchByCity(trackingSystemNew.packages,textFieldIngreseCiudad.getText()).toString());
            }
        });
        burbujaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackingSystemNew.Burbuja();
                textAreaBurbuja.setText(" ");
                for (int i=0;i<trackingSystemNew.getArregloBurbuja().size();i++){
                    textAreaBurbuja.append(trackingSystemNew.getArregloBurbuja().get(i) + "\n");
                }
            }
        });
        inserccionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trackingSystemNew.Insercion();
                textAreaInserccion.setText(" ");
                for (int i=0;i<trackingSystemNew.getArregloInsercion().size();i++){
                    textAreaInserccion.append(trackingSystemNew.getArregloInsercion().get(i) + "\n");
                }
            }
        });
    }
}
