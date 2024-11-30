package it.bvsolution.studiomedico.service.impl;

import it.bvsolution.studiomedico.service.StudioMedicoService;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

@Service
public class StudioMedicoServiceImpl implements StudioMedicoService {


    public byte[] fillPdfDocument(){
        byte[] outFile = new byte[]{};
        try {
            String nameIn = "pdf/invitoavisita.pdf";
            String nameOut = "pdf/invitoavisitacopilato.pdf";

            PDDocument pDDocument = PDDocument.load(getFileFromResourceAsStream(nameIn));

            PDAcroForm pDAcroForm = pDDocument.getDocumentCatalog().getAcroForm();

            PDField field = pDAcroForm.getField("nome_dottore");
            field.setValue("Nome Dottore");

            field = pDAcroForm.getField("indirizzo_dottore");
            field.setValue("Indirizzo dottore");

            field = pDAcroForm.getField("nome_soggetto");
            field.setValue("Nome Soggetto");

            field = pDAcroForm.getField("nome_avvocato");
            field.setValue("Nome Avvocato");

            field = pDAcroForm.getField("indirizzo_avvocato");
            field.setValue("Indirizzo Avvocato");

            field = pDAcroForm.getField("fax_avvocato");
            field.setValue("FAX Avvocato");

            field = pDAcroForm.getField("pec_avvocato");
            field.setValue("PEC Avvocato");

            field = pDAcroForm.getField("nome_assicurazione");
            field.setValue("nome assicurazione");

            field = pDAcroForm.getField("numero_sinistro");
            field.setValue("numero sinistro");

            field = pDAcroForm.getField("numero_sinistro");
            field.setValue("numero sinistro");

            field = pDAcroForm.getField("data_sinistro");
            field.setValue("data sinistro");

            field = pDAcroForm.getField("indirizzo_studio");
            field.setValue("indirizzo studio");

            field = pDAcroForm.getField("data_appuntamento");
            field.setValue("data appuntamento");

            field = pDAcroForm.getField("ora_appuntamento");
            field.setValue("ora appuntamento");

            pDDocument.save(nameOut);
            pDDocument.close();

            InputStream in = this.getClass().getClassLoader().getResourceAsStream(nameOut);

            outFile = IOUtils.toByteArray(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return outFile;
    }

    public InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }

    public File getPDFFileToFill(String filename) {
        URL url = this.getClass().getClassLoader().getResource(filename);
        File file = null;
        try {
            file = new File(url.toURI());
        } catch (URISyntaxException e) {
            file = new File(url.getPath());
        } finally {
            return file;
        }
    }
}
