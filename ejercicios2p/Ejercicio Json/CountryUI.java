package Ejercicios2p.json;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import Ejercicios.Ejercicios2p.json.CountriesController;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.*;

public class CountryUI extends JFrame implements ItemListener 
{
    CountriesController ctrl;
    JLabel list_lbl;
    JComboBox<Country> countries_cmb;
    JTextArea area;
    JPanel up_pnl;
    public CountryUI() {
        list_lbl = new JLabel("País");
        countries_cmb = new JComboBox<>();
        countries_cmb.addItemListener(this);
        area = new JTextArea();
        up_pnl = new JPanel();
        up_pnl.setLayout(new FlowLayout());
        up_pnl.add(list_lbl);
        up_pnl.add(countries_cmb);

        this.setLayout(new BorderLayout());
        this.add(up_pnl, BorderLayout.NORTH);
        this.add(area, BorderLayout.CENTER);
        this.setSize(600,200);
        
        try{
            ctrl = new CountriesController();
            populateCountries();
        }catch(Exception ex) {
            ex.printStackTrace();
        }
        this.setVisible(true);
    }

    private void populateCountries() {
        if (ctrl.list()!=null) {
            for(Country country: ctrl.list()) {
                countries_cmb.addItem(country);
            }
        }
        
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
        Country country = (Country)e.getItem();
        area.append("Code:" + country.getCode());
        area.append("Dial:" + country.getDial_code());
        area.append("Name:" + country.getName_en());
        area.append("Nombre:" + country.getName_es());
        area.append("\n");
    }
}
