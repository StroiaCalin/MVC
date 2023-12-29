package MVC;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View extends JFrame {
    private JPanel panel;
    private JFrame resultFrame=new JFrame();
    private JFrame frame=new JFrame();
    private JFrame frameClienti=new JFrame();
    private JFrame frameProduse=new JFrame();
    private JFrame frameComenzi=new JFrame();
    private JButton btnProduse = new JButton("Produse");
    private JButton btnComenzi = new JButton("Comenzi");
    private JButton btnClienti = new JButton("Clienti");
    private JButton btnBackClienti = new JButton("Back");
    private JButton btnViewClienti = new JButton("Clienti");
    private JButton btnInsertClienti = new JButton("Insert");
    private JButton btnDeleteClienti = new JButton("Delete");
    private JButton btnUpdateClienti = new JButton("Update");
    private JButton btnBackProduse = new JButton("Back");
    private JButton btnViewProduse = new JButton("Produse");
    private JButton btnInsertProduse = new JButton("Inserare");
    private JButton btnDeleteProduse = new JButton("Delete");
    private JButton btnUpdateProduse = new JButton("Update");
    private JButton btnBackComenzi = new JButton("Back");
    private JButton btnBackNush =new JButton("Back");
    private JButton btnViewComenzi = new JButton("Comenzi");
    private JButton btnInsertComenzi = new JButton("Insert");
    private JTextField titlu;
    private JTextField idProduse;
    private JTextField txtNumeClienti;
    private JTextField txtPrenumeClienti;
    private JTextField txtIdClienti;
    private JTextField txtTelefonClienti;
    private JTextField txtAdresaClienti;
    private JTextField textField_idClienti;
    private JTextField textField_numeClienti;
    private JTextField textField_prenumeClienti;
    private JTextField textField_emailClienti;
    private JTextField textField_telefonClienti;
    private JTextField textField_adresaClienti;
    private JTextField textField_afisare;
    private JTextField textField_afisarePR;
    private JTextField txtEmailClienti;
    private JTextField txtNumeProdus;
    private JTextField txtCantitateProdus;
    private JTextField txtIdProdus;
    private JTextField textField_idProduse;
    private JTextField textField_numeProduse;
    private JTextField textField_cantitateProduse;
    private JTextField txtProdus;
    private JTextField txtIdClient;
    private JTextField textField_idClient;
    private JTextField textField_c;
    private JTextField textField_numeProdus;
    private JTextField textField_afisareCO;
    private JTextField textField_cantitateComenzi;
    private JTextField textField_idProdus;
    private JTextField txtCantitateComenzi;
    private JTable table=new JTable();
    public View()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 200, 650, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        titlu = new JTextField();
        titlu.setEditable(false);
        titlu.setText("Tema 3");
        titlu.setBounds(250, 50, 250, 40);
        panel.add(titlu);

        btnProduse.setBounds(100, 150, 150, 40);
        panel.add(btnProduse);

        btnComenzi.setBounds(250, 150, 150, 40);
        panel.add(btnComenzi);

        btnClienti.setBounds(400, 150, 150, 40);
        panel.add(btnClienti);

        frame.add(panel);
        frame.setVisible(true);
    }


    public void frameProduse()
    {
        frameProduse.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameProduse.setBounds(200, 200, 650, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        btnViewProduse.setBounds(200, 50, 140, 25);
        panel.add(btnViewProduse);

        btnInsertProduse.setBounds(200, 85, 140, 25);
        panel.add(btnInsertProduse);

        btnDeleteProduse.setBounds(200, 120, 140, 25);
        panel.add(btnDeleteProduse);

        btnUpdateProduse.setBounds(200, 155, 140, 25);
        panel.add(btnUpdateProduse);

        btnBackProduse.setBounds(200, 230, 325, 25);
        panel.add(btnBackProduse);


        txtNumeProdus = new JTextField();
        txtNumeProdus.setEditable(false);
        txtNumeProdus.setText("Nume:");
        txtNumeProdus.setBounds(350, 50, 70, 25);
        panel.add(txtNumeProdus);

        txtCantitateProdus = new JTextField();
        txtCantitateProdus.setEditable(false);
        txtCantitateProdus.setText("Cantitate");
        txtCantitateProdus.setBounds(350, 85, 70, 25);
        panel.add(txtCantitateProdus);

        txtIdProdus = new JTextField();
        txtIdProdus.setEditable(false);
        txtIdProdus.setText("Id:");
        txtIdProdus.setBounds(350, 120, 70, 25);
        panel.add(txtIdProdus);


        textField_idProduse = new JTextField();
        textField_idProduse.setBounds(430, 120, 90, 25);
        panel.add(textField_idProduse);

        textField_numeProduse = new JTextField();
        textField_numeProduse.setBounds(430, 50, 90, 25);
        panel.add(textField_numeProduse);

        textField_cantitateProduse = new JTextField();
        textField_cantitateProduse.setBounds(430, 85, 90, 25);
        panel.add(textField_cantitateProduse);

        frameProduse.add(panel);
        frameProduse.setVisible(true);
    }


    public void frameClienti()
    {
        frameClienti.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameClienti.setBounds(200, 200, 650, 300);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        btnViewClienti.setBounds(200, 50, 140, 25);
        panel.add(btnViewClienti);

        btnInsertClienti.setBounds(200, 85, 140, 25);
        panel.add(btnInsertClienti);

        btnDeleteClienti.setBounds(200, 120, 140, 25);
        panel.add(btnDeleteClienti);

        btnUpdateClienti.setBounds(200, 155, 140, 25);
        panel.add(btnUpdateClienti);

        btnBackClienti.setBounds(200, 225,380 , 25);
        panel.add(btnBackClienti);

        txtIdClienti = new JTextField();
        txtIdClienti.setText("Id:");
        txtIdClienti.setEditable(false);
        txtIdClienti.setBounds(200, 190, 70, 25);
        panel.add(txtIdClienti);

        txtNumeClienti = new JTextField();
        txtNumeClienti.setEditable(false);
        txtNumeClienti.setText("Nume:");
        txtNumeClienti.setBounds(350, 50, 70, 25);
        panel.add(txtNumeClienti);

        txtPrenumeClienti = new JTextField();
        txtPrenumeClienti.setText("Prenume:");
        txtPrenumeClienti.setEditable(false);
        txtPrenumeClienti.setBounds(350, 85, 70, 25);
        panel.add(txtPrenumeClienti);

        txtTelefonClienti = new JTextField();
        txtTelefonClienti.setText("Telefon:");
        txtTelefonClienti.setEditable(false);
        txtTelefonClienti.setBounds(350, 120, 70, 25);
        panel.add(txtTelefonClienti);

        txtAdresaClienti = new JTextField();
        txtAdresaClienti.setText("Adresa:");
        txtAdresaClienti.setEditable(false);
        txtAdresaClienti.setBounds(350, 155, 70, 25);
        panel.add(txtAdresaClienti);

        txtEmailClienti = new JTextField();
        txtEmailClienti.setText("Gmail:");
        txtEmailClienti.setEditable(false);
        txtEmailClienti.setBounds(350, 190, 70, 25);
        panel.add(txtEmailClienti);

        textField_idClienti = new JTextField();
        textField_idClienti.setBounds(280, 190, 60, 25);
        panel.add(textField_idClienti);

        textField_numeClienti = new JTextField();;
        textField_numeClienti.setBounds(430, 50, 150, 25);
        panel.add(textField_numeClienti);

        textField_prenumeClienti = new JTextField();
        textField_prenumeClienti.setBounds(430, 85, 150, 25);
        panel.add(textField_prenumeClienti);

        textField_telefonClienti = new JTextField();
        textField_telefonClienti.setBounds(430, 120, 150, 25);
        panel.add(textField_telefonClienti);

        textField_adresaClienti = new JTextField();
        textField_adresaClienti.setBounds(430, 155, 150, 25);
        panel.add(textField_adresaClienti);

        textField_emailClienti = new JTextField();
        textField_emailClienti.setBounds(430, 190, 150, 25);
        panel.add(textField_emailClienti);

        frameClienti.add(panel);
        frameClienti.setVisible(true);

    }

    public void frameComenzi()
    {
        frameComenzi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frameComenzi.setBounds(200, 200, 650, 300);

        JPanel panel = new JPanel();
        panel.setBorder(null);
        panel.setLayout(null);

        btnViewComenzi.setBounds(200, 50, 140, 25);
        panel.add(btnViewComenzi);

        btnInsertComenzi.setBounds(200, 85, 140, 25);
        panel.add(btnInsertComenzi);

        btnBackComenzi.setBounds(200, 190, 380, 25);
        panel.add(btnBackComenzi);

        txtProdus = new JTextField();
        txtProdus.setText("Produs:");
        txtProdus.setEditable(false);
        txtProdus.setBounds(350, 50, 70, 25);
        panel.add(txtProdus);

        txtIdClient = new JTextField();
        txtIdClient.setText("Id client:");
        txtIdClient.setEditable(false);
        txtIdClient.setBounds(350, 85, 70, 25);
        panel.add(txtIdClient);

        textField_idClient = new JTextField();
        textField_idClient.setBounds(430, 85, 150, 25);
        panel.add(textField_idClient);

        textField_numeProdus = new JTextField();
        textField_numeProdus.setBounds(430, 50, 150, 25);
        panel.add(textField_numeProdus);

        txtCantitateComenzi = new JTextField();
        txtCantitateComenzi.setText("Cantitate:");
        txtCantitateComenzi.setEditable(false);
        txtCantitateComenzi.setBounds(350, 155, 70, 25);
        panel.add(txtCantitateComenzi);

        textField_cantitateComenzi = new JTextField();
        textField_cantitateComenzi.setBounds(430, 155, 150, 25);
        panel.add(textField_cantitateComenzi);

        idProduse = new JTextField();
        idProduse.setText("Id produs:");
        idProduse.setEditable(false);
        idProduse.setBounds(350, 120, 70, 25);
        panel.add(idProduse);

        textField_idProduse = new JTextField();
        textField_idProduse.setBounds(430, 120, 150, 25);
        panel.add(textField_idProduse);

        frameComenzi.add(panel);
        frameComenzi.setVisible(true);
    }
    public void createResultFrame() {
        resultFrame=new JFrame();
        resultFrame.getContentPane().setBackground(Color.black);
        resultFrame.setResizable(false);
        resultFrame.setBounds(100, 100, 606, 509);
        resultFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resultFrame.getContentPane().setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(10, 10, 570, 420);
        resultFrame.getContentPane().add(scrollPane);
        scrollPane.setViewportView(table);

        btnBackNush.setFont(new Font("Times New Roman", Font.BOLD, 15));
        btnBackNush.setBounds(451, 450, 85, 21);
        resultFrame.getContentPane().add(btnBackNush);
        resultFrame.getContentPane().add(scrollPane);
        resultFrame.setVisible(true);
    }
    public void addListenerClienti(ActionListener listenerClienti) {
        btnClienti.addActionListener(listenerClienti);
    }
    public void addListenerProduse(ActionListener listenerProduse) {
        btnProduse.addActionListener(listenerProduse);
    }
    public void addListenerComenzi(ActionListener listenerComenzi) {
        btnComenzi.addActionListener(listenerComenzi);
    }
    public void addListenerVizualizareClienti(ActionListener listenerVizCL) {
        btnViewClienti.addActionListener(listenerVizCL);
    }
    public void addListenerInsertClienti(ActionListener listenerInsCL) {
        btnInsertClienti.addActionListener(listenerInsCL);
    }
    public void addListenerDeleteClienti(ActionListener listenerStergCL) {
        btnDeleteClienti.addActionListener(listenerStergCL);
    }
    public void addListenerUpdateClienti(ActionListener listenerUpCL) {
        btnUpdateClienti.addActionListener(listenerUpCL);
    }
    public void addListenerBackClienti(ActionListener listenerBackCL) {
        btnBackClienti.addActionListener(listenerBackCL);
    }
    public void addListenerVizualizareProduse(ActionListener listenerVizPR) {
        btnViewProduse.addActionListener(listenerVizPR);
    }
    public void addListenerInsertProduse(ActionListener listenerInsPR) {
        btnInsertProduse.addActionListener(listenerInsPR);
    }
    public void addListenerStergProduse(ActionListener listenerStergPR) {
        btnDeleteProduse.addActionListener(listenerStergPR);
    }
    public void addListenerUpdateProduse(ActionListener listenerUpPR) {
        btnUpdateProduse.addActionListener(listenerUpPR);
    }
    public void addListenerBackProduse(ActionListener listenerBackPR) {
        btnBackProduse.addActionListener(listenerBackPR);
    }
    public void addListenerVizualizareComenzi(ActionListener listenerVizCO) {
        btnViewComenzi.addActionListener(listenerVizCO);
    }
    public void addListenerInsCO(ActionListener listenerInsCO) {
        btnInsertComenzi.addActionListener(listenerInsCO);
    }
    public void addListenerBackComenzi(ActionListener listenerBackCO) {
        btnBackComenzi.addActionListener(listenerBackCO);
    }
    public void addListenerBackTabel(ActionListener listenerBackR) {
        btnBackNush.addActionListener(listenerBackR);
    }
    public JFrame getFrame() {
        return frame;
    }
    public void setFrame(JFrame frame) {
        this.frame = frame;
    }
    public JFrame getFrameClienti() {
        return frameClienti;
    }
    public void setFrameClienti(JFrame frameClienti) {
        this.frameClienti = frameClienti;
    }
    public JFrame getFrameProduse() {
        return frameProduse;
    }
    public void setFrameProduse(JFrame frameProduse) {
        this.frameProduse = frameProduse;
    }
    public JFrame getFrameComenzi() {
        return frameComenzi;
    }
    public void setFrameComenzi(JFrame frameComenzi) {
        this.frameComenzi = frameComenzi;
    }
    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    public JFrame getResultFrame() {
        return resultFrame;
    }
    public void setResultFrame(JFrame resultFrame) {
        this.resultFrame = resultFrame;
    }

    public String getTextField_idClienti() {
        return textField_idClienti.getText();
    }
    public void setTextField_idClienti(JTextField textField_idClienti) {
        this.textField_idClienti = textField_idClienti;
    }
    public String getTextField_numeClienti() {
        return textField_numeClienti.getText();
    }
    public void setTextField_numeClienti(JTextField textField_numeClienti) {
        this.textField_numeClienti = textField_numeClienti;
    }
    public String getTextField_prenumeClienti() {
        return textField_prenumeClienti.getText();
    }
    public void setTextField_prenumeClienti(JTextField textField_prenumeClienti) {
        this.textField_prenumeClienti = textField_prenumeClienti;
    }
    public String getTextField_emailClienti() {
        return textField_emailClienti.getText();
    }
    public void setTextField_emailClienti(JTextField textField_emailClienti) {
        this.textField_emailClienti = textField_emailClienti;
    }
    public String getTextField_telefonClienti() {
        return textField_telefonClienti.getText();
    }
    public void setTextField_telefonClienti(JTextField textField_telefonClienti) {
        this.textField_telefonClienti = textField_telefonClienti;
    }
    public String getTextField_adresaClienti() {
        return textField_adresaClienti.getText();
    }
    public void setTextField_adresaClienti(JTextField textField_adresaClienti) {
        this.textField_adresaClienti = textField_adresaClienti;
    }
    public void setTextField_afisare(String textField_afisare) {
        this.textField_afisare.setText(textField_afisare);
    }
    public String getTextField_afisarePR() {
        return textField_afisarePR.getText();
    }
    public String getTextField_idProduse() {
        return textField_idProduse.getText();
    }
    public String getTextField_numeProduse() {
        return textField_numeProduse.getText();
    }
    public String getTextField_cantitateProduse() {
        return textField_cantitateProduse.getText();
    }
    public Integer getTextField_idClient() {
        return Integer.parseInt((textField_idClient.getText()));
    }
    public String getTextField_cumparatorComenzi() {
        return textField_c.getText();
    }
    public String getTextField_numeProdus() {
        return textField_numeProdus.getText();
    }
    public String getTextField_afisareCO() {
        return textField_afisareCO.getText();
    }
    public String getTextField_cantitateComenzi() {
        return textField_cantitateComenzi.getText();
    }
    public void setTextField_afisarePR(String textField_afisarePR) {
        this.textField_afisarePR.setText(textField_afisarePR);
    }
    public void setTextField_afisareCO(String textField_afisareCO) {
        this.textField_afisareCO.setText(textField_afisareCO);
    }
    public String getTextField_idProdus() {
        return textField_idProdus.getText();
    }
    public void setTextField_idProdus(JTextField textField_idProdus) {
        this.textField_idProdus = textField_idProdus;
    }

    public String getTextField_idComenzi() {
        return textField_idClienti.getText();
    }
    public void addListenerAdaugareProduse(ActionListener listenerAdaugareProduse) {
        btnInsertComenzi.addActionListener(listenerAdaugareProduse);
    }

}
