package com.krolka;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageTree;

import java.io.File;
import java.io.IOException;

public class PdfUtility {

    private String nameSufix = "";
    private final String extention = ".pdf";

    public void prepare(File file) throws IOException {

        PDDocument document = null;

        document = PDDocument.load(file);

        document = addEmptyPage(document);

        document = reorderPages(document);

        String newPath;
        newPath = file.getPath();
        newPath = newPath.substring(0, newPath.length() - 4);

        savePdf(document, newPath + nameSufix + extention);

        nameSufix = "";

    }


    public PDDocument addEmptyPage(PDDocument document) throws IOException {

        int pages = document.getPages().getCount();

        // Check if PAGES greater than 100.
        if (pages > 100) {
            toManyPages(document);
        }

        // Check if PAGES are 1,2,3 or 4.
        if (pages == 1) {
            addZeroEmpty(document);
        } else if (pages == 2) {
            addZeroEmpty(document);
        } else if (pages == 3) {
            addOneEmpty(document);
        } else if (pages == 4) {
            addZeroEmpty(document);
        }

        //Check the rest of the division
        if (pages > 4) {
            int rest = pages % 4;

            if (rest == 1) {
                addThreeEmpty(document);
            } else if (rest == 2) {
                addTwoEmpty(document);
            } else if (rest == 3) {
                addOneEmpty(document);
            } else if (rest == 0) {
                addZeroEmpty(document);
            }
        }
        return document;
    }

    public PDDocument reorderPages(PDDocument document) {
        System.out.println("=============REORDER PAGES===========");

        int pages = document.getPages().getCount();
        PDDocument reorderedDoc = new PDDocument();
        PDPageTree allPages = new PDPageTree();
        int[] pagesList = null;

        System.out.println("pages:" + pages);

        if (pages > 4) {
            switch (pages) {
                case 8:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }
                    break;

                case 12:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 16:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 20:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 24:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 28:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 32:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 36:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 40:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 44:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 48:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 52:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 56:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 60:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 64:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 68:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 72:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{71,72,69,70,67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 76:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{75,76,73,74,71,72,69,70,67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 80:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{79,80,77,78,75,76,73,74,71,72,69,70,67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 84:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{83,84,81,82,79,80,77,78,75,76,73,74,71,72,69,70,67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 88:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{87,88,85,86,83,84,81,82,79,80,77,78,75,76,73,74,71,72,69,70,67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 92:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{91,92,89,90,87,88,85,86,83,84,81,82,79,80,77,78,75,76,73,74,71,72,69,70,67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 96:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{95,96,93,94,91,92,89,90,87,88,85,86,83,84,81,82,79,80,77,78,75,76,73,74,71,72,69,70,67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;
                case 100:
                    allPages = reorderedDoc.getDocumentCatalog().getPages();
                    pagesList = new int[]{99,100,97,98,95,96,93,94,91,92,89,90,87,88,85,86,83,84,81,82,79,80,77,78,75,76,73,74,71,72,69,70,67,68,65,66,63,64,61,62,59,60,57,58,55,56,53,54,51,52,49,50,47,48,45,46,43,44,41,42,39,40,37,38,35,36,33,34,31,32,29,30,27, 28, 25, 26, 23, 24, 21, 22, 19, 20, 17, 18, 15, 16, 13, 14, 11, 12, 9, 10, 7, 8, 5, 6, 3, 4, 1, 2};

                    for (int i : pagesList) {
                        allPages.add(document.getPage(i - 1));
                    }

                    break;


                default:
                    System.out.println("Return doc ");
                    return document;
            }
            return reorderedDoc;
        }
        return document;
    }


    public void savePdf(PDDocument document, String path) throws IOException {

        System.out.println("============SAVE FILE===============");
        System.out.println(path);
        document.save(path);
        document.close();
    }

    public PDDocument addOneEmpty(PDDocument document) {

        document.addPage(new PDPage());
        nameSufix = nameSufix + " +1 P2D";
        return document;
    }

    public PDDocument addTwoEmpty(PDDocument document) {

        document.addPage(new PDPage());
        document.addPage(new PDPage());
        nameSufix = nameSufix + " +2 P2D";
        return document;
    }

    public PDDocument addThreeEmpty(PDDocument document) {

        document.addPage(new PDPage());
        document.addPage(new PDPage());
        document.addPage(new PDPage());
        nameSufix = nameSufix + " +3 P2D";
        return document;
    }

    public PDDocument addZeroEmpty(PDDocument document) {

        nameSufix = nameSufix + " +0 P2D";
        return document;
    }

    public PDDocument toManyPages(PDDocument document) {

        nameSufix = nameSufix + " + toManyPages";
        return document;
    }


}
