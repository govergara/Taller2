/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;         // |
import java.io.IOException;          // |\ Librerías
import java.util.ArrayList;    // |/ JDOM
import java.util.List;
import org.jdom2.Attribute;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
/**
 *
 * @author cristopherarredondo
 */
public class FileRead {

    private File archivo = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private SAXBuilder builder;
    private File xmlFile;
    private String file;
    private ArrayList<Familia> fam;
       
      public FileRead(String file){
         this.file=file;
         builder = new SAXBuilder();
         xmlFile = new File(file);
         System.out.println(xmlFile);
         fam = new ArrayList<Familia>();
         
      }
      
      public void leer(){
        try
        {
            //Se crea el documento a traves del archivo
            Document document = (Document) builder.build( xmlFile );

            //Se obtiene la raiz 'tables'
            Element rootNode = document.getRootElement();

            //Se obtiene la lista de hijos de la raiz 'tables'
            List list = rootNode.getChildren() ;
            //Se recorre la lista de hijos de 'tables'
            for ( int i = 0; i < list.size(); i++ )
            {
                //Se obtiene el elemento 'Familia'
                Element familia = (Element) list.get(i);

                //Se obtiene el atributo 'nombre' que esta en el tag 'tabla'
                String nombreTabla = familia.getAttributeValue("nombre");

                //Se obtiene la lista de hijos del tag 'tabla'
                List lista_campos = familia.getChildren();

                Familia aux = new Familia(nombreTabla);

                //Se recorre la lista de campos
                for ( int j = 0; j < lista_campos.size(); j++ )
                {
                    //Se obtiene el elemento 'campo'
                    Element campo = (Element)lista_campos.get( j );
                    if(campo.getName().equals("MiembroFamilia")){

                        String nombre = campo.getChildTextTrim("nombre");
                        String rut = campo.getChildTextTrim("rut");
                        String clave = campo.getChildTextTrim("clave");

                        MiembroFamilia mf = new MiembroFamilia(nombre,rut,clave);
                        aux.addMiembro(mf);
                    }
                    else if(campo.getName().equals("Fotografia")){
                        String path = campo.getChildTextTrim("path");
                        String comentario = campo.getChildTextTrim("comentario");
                        Fotografia f = new Fotografia(path,comentario);
                        aux.addFoto(f);
                    }
                }
                fam.add(aux);
            }
        }catch ( IOException io ) {
            System.out.println( io.getMessage() );
        }catch ( JDOMException jdomex ) {
            System.out.println( jdomex.getMessage() );
        }
    }
    
      
    public void setFamilias(ArrayList<Familia> aux){
        this.fam=aux;
    }
    
    public ArrayList<Familia> getFamilias(){
        return this.fam;
    }
    
  public void escribir(){
        try{
            Element company = new Element("familias");
            for (int i = 0; i <fam.size(); i++) {
                Element familia = new Element("Familia");
                Familia aux = fam.get(i);
                familia.setAttribute(new Attribute("nombre", aux.getNombre()));
                ArrayList<MiembroFamilia> mf = fam.get(i).getMiembros();
                for (int j = 0; j < mf.size(); j++) {
                    Element miembro = new Element("MiembroFamilia");
                    miembro.addContent(new Element("nombre").setText(mf.get(j).getNombre()));
                    miembro.addContent(new Element("rut").setText(mf.get(j).getRut()));
                    miembro.addContent(new Element("clave").setText(mf.get(j).getClave()));
                    familia.addContent(miembro);
                }
                ArrayList<Fotografia> f = fam.get(i).getFotos();
                for (int j = 0; j < f.size(); j++) {
                    Element fotos = new Element("Fotografia");
                    fotos.addContent(new Element("path").setText(f.get(j).getPath()));
                    fotos.addContent(new Element("comentario").setText(f.get(j).getComentario()));
                    familia.addContent(fotos);
                }
                company.addContent(familia);
            }
                // new XMLOutputter().output(doc, System.out);
            XMLOutputter xmlOutput = new XMLOutputter();

            // display nice nice
            xmlOutput.setFormat(Format.getPrettyFormat());
            xmlOutput.output ( new Document(company), new FileOutputStream(file) );
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
}
