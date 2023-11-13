package ro.uvt.info.designpatternslab2023.books;

public class AlignLeft implements AlignStrategy{

    @Override
    public void render(String p, Context c) {
        System.out.println("Aligning paragraph to the left:");
        for (int i = 0; i < c.getNumber_row(); i++) {
            System.out.print(p);
            for (int j = p.length(); j < c.getNumber_coll(); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }}