//Classe ComprovanteDevolucao
package Control.DevolverVeiculo;

import java.io.FileOutputStream;
import java.io.OutputStream;

import Model.Devolucao;

import Util.Conversao;
import View.Datas.DataFormatada;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

public class ComprovanteDevolucao {
	
	public ComprovanteDevolucao(Devolucao devolucao) throws Exception {
		
		Document doc = null;
        OutputStream os = null;
  
        try{
        	//cria o documento tamanho A4, margens de 2,54cm
        	doc = new Document(PageSize.A4, 72, 72, 72, 72);
  
        	//cria a stream de saída
        	os = new FileOutputStream("relatorioDevolucao.pdf");
  
        	//associa a stream de saída ao 
        	PdfWriter.getInstance(doc, os);
  
        	//abre o documento
        	doc.open();
  
        	//adiciona o texto ao PDF
        	Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
        	Paragraph p = new Paragraph("Dados da Devolução" , f);
        	p.setSpacingAfter(30);
        	p.setAlignment(Element.ALIGN_LEFT);
        
        	doc.add(p);
        
        	p = new Paragraph("ID Devolução: " + devolucao.getId() , new Font(FontFamily.UNDEFINED, 15, Font.BOLD));
        
        	doc.add(p);
        

        	p = new Paragraph( "Nome do Cliente: " + devolucao.getLocacao().getClienteEscolhido().getNome() + "        " + 
				"CNPJ/CPF: " + devolucao.getLocacao().getClienteEscolhido().getRegistro() );

                
        	doc.add(p);
        
        	p = new Paragraph("Data da Retirada:     " +  DataFormatada.parseStringDataCompleta(devolucao.getLocacao().getDtaRetirada()) + "     " + 		
        						"Agência Retirada:" + devolucao.getLocacao().getAgenciaRetirada().getNome());
        	p.setSpacingBefore(20);
        
        	doc.add(p);
        
        	p = new Paragraph("Data de Devolução: " + DataFormatada.parseStringDataCompleta(devolucao.getDtaDevolucao()) + "    " + 
        					"Agência Devolução:" + devolucao.getAgenciaDevolucao().getNome());
        
        	doc.add(p);
        
        	p = new Paragraph("Tipo de Tarifa: " +  devolucao.getLocacao().getTipoTarifa()+ "                                       " + 
        				  "Qtd dias:" + devolucao.getQtdDias() );
        
        	doc.add(p);
        
        	p = new Paragraph("Total: R$" + Conversao.formatDouble(devolucao.getTotal()) , new Font(FontFamily.UNDEFINED, 11, Font.BOLDITALIC) );
        	p.setSpacingBefore(10);
        
        	doc.add(p);
               
        	        
        
        }
                
        finally {
            if (doc != null) {
                //fechamento do documento
                doc.close();
            }
            if (os != null) {
               //fechamento da stream de saída
               os.close();
            }
        }	
	}
	
	public static boolean imprimiComprovante(Devolucao dev){
		try{
			ComprovanteDevolucao app = new ComprovanteDevolucao(dev);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
}
