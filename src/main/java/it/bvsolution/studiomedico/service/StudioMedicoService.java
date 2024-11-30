package it.bvsolution.studiomedico.service;

import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

public interface StudioMedicoService {


    byte[] fillPdfDocument();

    InputStream getFileFromResourceAsStream(String fileName);

    File getPDFFileToFill(String filename);
}
