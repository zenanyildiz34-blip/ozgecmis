package org.example.service;

import com.lowagie.text.*;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.example.model.Experience;
import org.example.model.Person;

import java.awt.Color;
import java.io.FileOutputStream;

public class PdfService {

    public void createResume(Person person, String outputFilePath) {
        Document document = new Document(PageSize.A4, 36, 36, 36, 36);

        try {
            PdfWriter.getInstance(document, new FileOutputStream(outputFilePath));
            document.open();

            // Türkçe karakter desteği (macOS Arial TrueType veya standart Türkçe kodlama)
            BaseFont baseFont;
            try {
                baseFont = BaseFont.createFont("/System/Library/Fonts/Supplemental/Arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
            } catch (Exception e) {
                baseFont = BaseFont.createFont(BaseFont.HELVETICA, "Cp1254", BaseFont.NOT_EMBEDDED);
            }

            Font titleFont = new Font(baseFont, 18, Font.BOLD, Color.BLACK);
            Font subtitleFont = new Font(baseFont, 11, Font.BOLD, new Color(40, 40, 40));
            Font sectionTitleFont = new Font(baseFont, 12, Font.BOLD, new Color(0, 51, 102));
            Font textFont = new Font(baseFont, 9, Font.NORMAL, Color.DARK_GRAY);
            Font boldTextFont = new Font(baseFont, 9, Font.BOLD, Color.BLACK);
            Font smallFont = new Font(baseFont, 8, Font.NORMAL, Color.GRAY);

            // 1. Üst Kısım: Bilgiler ve Fotoğraf
            PdfPTable headerTable = new PdfPTable(2);
            headerTable.setWidthPercentage(100);
            headerTable.setWidths(new float[]{75, 25});

            PdfPCell infoCell = new PdfPCell();
            infoCell.setBorder(Rectangle.NO_BORDER);
            infoCell.addElement(new Paragraph(person.getFullName(), titleFont));
            infoCell.addElement(new Paragraph(person.getJobTitle(), subtitleFont));
            infoCell.addElement(new Paragraph("E-posta: " + person.getEmail() + " | Tel: " + person.getPhone(), textFont));
            infoCell.addElement(new Paragraph("Adres: " + person.getAddress() + " | LinkedIn: " + person.getLinkedin(), smallFont));
            headerTable.addCell(infoCell);

            PdfPCell photoCell = new PdfPCell();
            photoCell.setBorder(Rectangle.NO_BORDER);
            photoCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
            try {
                Image photo = Image.getInstance(person.getPhotoPath());
                photo.scaleToFit(85, 85);
                photoCell.addElement(photo);
            } catch (Exception e) {
                photoCell.addElement(new Paragraph("[Fotoğraf]", smallFont));
            }
            headerTable.addCell(photoCell);
            document.add(headerTable);

            addDivider(document);

            // 2. Hakkımda ve Kariyer Hedefi
            document.add(new Paragraph("HAKKIMDA & KARİYER HEDEFİ", sectionTitleFont));
            document.add(new Paragraph(person.getAbout(), textFont));
            document.add(new Paragraph(person.getCareerGoal(), textFont));
            document.add(new Paragraph(" "));

            // 3. Eğitim
            document.add(new Paragraph("EĞİTİM", sectionTitleFont));
            document.add(new Paragraph(person.getEducation(), textFont));
            document.add(new Paragraph(" "));

            // 4. İş Deneyimleri (3 Adet)
            document.add(new Paragraph("İŞ DENEYİMLERİ", sectionTitleFont));
            for (Experience exp : person.getExperiences()) {
                Paragraph expHeader = new Paragraph(exp.getTitle() + " - " + exp.getCompany() + " (" + exp.getDuration() + ")", boldTextFont);
                Paragraph expBody = new Paragraph(exp.getDescription(), textFont);
                document.add(expHeader);
                document.add(expBody);
                document.add(new Paragraph(" "));
            }

            // 5. Beceriler ve Yabancı Diller
            document.add(new Paragraph("BECERİLER VE DİLLER", sectionTitleFont));
            StringBuilder sbSkills = new StringBuilder("Beceriler: ");
            for (String s : person.getSkills()) sbSkills.append(s).append(" • ");
            document.add(new Paragraph(sbSkills.toString(), textFont));

            StringBuilder sbLangs = new StringBuilder("Yabancı Diller: ");
            for (String l : person.getLanguages()) sbLangs.append(l).append(" • ");
            document.add(new Paragraph(sbLangs.toString(), textFont));
            document.add(new Paragraph(" "));

            // 6. Kurslar ve Sertifikalar
            document.add(new Paragraph("KURSLAR VE SERTİFİKALAR", sectionTitleFont));
            for (String cert : person.getCertificates()) {
                document.add(new Paragraph("• " + cert, textFont));
            }

            document.close();
            System.out.println("Özgeçmiş başarıyla üretildi: " + outputFilePath);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addDivider(Document doc) throws DocumentException {
        Paragraph divider = new Paragraph("______________________________________________________________________________",
                FontFactory.getFont(FontFactory.HELVETICA, 8, Color.LIGHT_GRAY));
        divider.setSpacingAfter(8);
        doc.add(divider);
    }
}