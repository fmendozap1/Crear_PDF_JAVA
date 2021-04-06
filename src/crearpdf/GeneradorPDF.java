/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crearpdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.JOptionPane;

/**
 *
 * @author fmendoza1
 */
public class GeneradorPDF 
{
    
    public void GenerarPDF(String Titulo, String Nombre, String Apellido, long Identificacion, double valorpagado)throws FileNotFoundException,DocumentException
    {
     
        if( !"".equals(Nombre) || !"".equals(Apellido) || (Identificacion<0 && Identificacion>9999999) || (valorpagado<0 && valorpagado>99999999))
        {
            File path = new File("src/Datos/"+Titulo+".pdf");
            try 
            {
                FileOutputStream documento=new FileOutputStream(path);
                Document docgen= new Document();
                PdfWriter.getInstance(docgen, documento);
                docgen.open();
                
                Paragraph parrafo=new Paragraph("Informacion Del Trabajador");
                parrafo.setAlignment(1);
                docgen.add(parrafo);
                
                docgen.add(new Paragraph("Nombres: "+Nombre+" "+Apellido));
                docgen.add(new Paragraph("Identificacion: "+Identificacion));
                docgen.add(new Paragraph("Salario"+valorpagado));
                docgen.close();
                JOptionPane.showMessageDialog(null,"Recibo Generado Satisfactoriamente...");
                
            } catch (Exception e) 
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
        else
        {
            JOptionPane.showMessageDialog(null,"No es posible crear el documento porque uno de los campos esta vacio");
        }
        
    }
    
}
