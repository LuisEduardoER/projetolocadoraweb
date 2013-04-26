//Classe ComprovanteLocacaoPF
package Control.RealizarLocacao;

import java.io.FileOutputStream;
import java.io.OutputStream;

import model.Locacao;

import Util.Conversao;
import View.Datas.DataFormatada;

import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;

public class ComprovanteLocacaoPF {
	
	public ComprovanteLocacaoPF(Locacao locacao) throws Exception {
		
		Document doc = null;
        OutputStream os = null;
  
        try{
        	//cria o documento tamanho A4, margens de 2,54cm
        	doc = new Document(PageSize.A4, 72, 72, 72, 72);
  
        	//cria a stream de saída
        	os = new FileOutputStream("relatorioLocacaoPF.pdf");
  
        	//associa a stream de saída ao 
        	PdfWriter.getInstance(doc, os);
  
        	//abre o documento
        	doc.open();
  
        	//adiciona o texto ao PDF
        	Font f = new Font(FontFamily.COURIER, 20, Font.BOLD);
        	Paragraph p = new Paragraph("Dados da Locação" , f);
        	p.setSpacingAfter(30);
        	p.setAlignment(Element.ALIGN_LEFT);
        
        	doc.add(p);
        
        	p = new Paragraph("ID Locação: " + locacao.getId() , new Font(FontFamily.UNDEFINED, 15, Font.BOLD));
        
        	doc.add(p);
        

        	p = new Paragraph( "Nome do Cliente: " + locacao.getClienteEscolhido().getNome() + "        " + 
				"CNPJ/CPF: " + locacao.getClienteEscolhido().getRegistro() );

                
        	doc.add(p);
        
        	p = new Paragraph("Data da Retirada:     " +  DataFormatada.parseStringDataCompleta(locacao.getDtaRetirada()) + "     " + 		
        						"Agência Retirada:" + locacao.getAgenciaRetirada().getNome());
        	p.setSpacingBefore(20);
        
        	doc.add(p);
        
        	p = new Paragraph("Data de Devolução: " + DataFormatada.parseStringDataCompleta(locacao.getDtaPrevDevolucao()) + "    " + 
        					"Agência Devolução:" + locacao.getAgenciaDevolucao().getNome());
        
        	doc.add(p);
        
        	p = new Paragraph("Tipo de Tarifa: " +  locacao.getTipoTarifa()+ "                                       " + 
        				  "Qtd dias:" + locacao.getQtdDias() );
        
        	doc.add(p);
        
        	p = new Paragraph("Total: R$" + Conversao.formatDouble(locacao.getTotal()) , new Font(FontFamily.UNDEFINED, 11, Font.BOLDITALIC) );
        	p.setSpacingBefore(10);
        
        	doc.add(p);
        
//        CAMPOS DADOS DO VEÍCULO - PF
        
        	f = new Font(FontFamily.COURIER, 20, Font.BOLD);
        	p = new Paragraph("Dados do Veículo" , f);
        	p.setSpacingBefore(30);
        	p.setSpacingAfter(10);
        
        	doc.add(p);
        
        	p = new Paragraph("Grupo:  " + locacao.getVeiculoEscolhido().getGrupo().getNome() );
        
        	doc.add(p);
        
        	p = new Paragraph("Acessórios: R$ " + Conversao.formatDouble(locacao.getVeiculoEscolhido().getTotalAcessorios()) );
        
        	doc.add(p);
        
        	p = new Paragraph("Veículo: "+locacao.getVeiculoEscolhido().getModelo() );
        
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
	
	public static boolean imprimiComprovante(Locacao loc){
		try{
			ComprovanteLocacaoPF app = new ComprovanteLocacaoPF(loc);
			return true;
		}catch(Exception e){
			return false;
		}
	}
	
}
