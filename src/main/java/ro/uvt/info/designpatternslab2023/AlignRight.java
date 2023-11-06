package ro.uvt.info.designpatternslab2023;

import javax.naming.Context;

public class AlignRight implements AlignStrategy{
    @Override
    public void render(String p, ro.uvt.info.designpatternslab2023.Context c) {
        System.out.println("Aligning paragraph to the right:");
        for (int i = 0; i < c.getNumber_row(); i++) {
            for (int j = 0; j < c.getNumber_coll() - p.length(); j++) {
                System.out.print(" ");
            }
            System.out.println(p);
        }
    }
}
