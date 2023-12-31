package ro.uvt.info.designpatternslab2023.services;

import ro.uvt.info.designpatternslab2023.models.Context;

public class AlignCenter implements AlignStrategy{

    @Override
    public void render(String p, Context c) {
        System.out.println("Aligning paragraph to the center:");
        for (int i = 0; i < c.getNumber_row(); i++) {
            int padding = (c.getNumber_coll() - p.length()) / 2;
            for (int j = 0; j < padding; j++) {
                System.out.print(" ");
            }
            System.out.print(p);
            for (int j = padding + p.length(); j < c.getNumber_row(); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
