public class FindFiletype {
    public void findFiletype(){
        String filename = "hallodocx";
        int index = filename.lastIndexOf(".");
        // Falls es keine Dateiendung gibt, gebe "Es gibt keine Dateiendung" aus
        // ansonsten gebe die Dateiendung aus.
        if(index >= 0){
            String filetype = filename.substring(index);
            System.out.println(filetype);
        } else {
            System.out.println("Es gibt keine Dateiendung.");
        }

    }
}
