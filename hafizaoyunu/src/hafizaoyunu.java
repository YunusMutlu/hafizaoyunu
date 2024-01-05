import java.util.Scanner;

public class hafizaoyunu {
    private static kartt[][]  kartlar = new kartt[4][4];
    public static void main(String[] args) {
        int a,b,c,d;
        Scanner inp = new Scanner(System.in);
        kartlar[0][0]= new kartt('D');
        kartlar[0][1]= new kartt('B');
        kartlar[0][2]= new kartt('G');
        kartlar[0][3]= new kartt('A');
        kartlar[1][0]= new kartt('E');
        kartlar[1][1]= new kartt('H');
        kartlar[1][2]= new kartt('C');
        kartlar[1][3]= new kartt('F');
        kartlar[2][0]= new kartt('B');
        kartlar[2][1]= new kartt('A');
        kartlar[2][2]= new kartt('F');
        kartlar[2][3]= new kartt('D');
        kartlar[3][0]= new kartt('H');
        kartlar[3][1]= new kartt('C');
        kartlar[3][2]= new kartt('G');
        kartlar[3][3]= new kartt('E');
        int hak=0;
        while(hak<99){
            System.out.println("Tahminde bulunmak istediğiniz yerin satirini giriniz:");
            a= inp.nextInt();
            System.out.println("Tahminde bulunmak istediğiniz yerin sütununu giriniz:");
            b= inp.nextInt();
            if(a>3 || b>3){
                System.out.println("Lütfen 3 ten büyük sayi girmeyin.");
                continue;
            }
            System.out.println("Seçtiğiniz yerdeki harf="+kartlar[a][b].getDeger());
            System.out.println("Tahminde bulunmak istediğiniz yerin satirini giriniz:");
            c= inp.nextInt();
            System.out.println("Tahminde bulunmak istediğiniz yerin sütununu giriniz:");
            d= inp.nextInt();
            if( c>3||d>3){
                System.out.println("Lütfen 3 ten büyük sayi girmeyin.");
                continue;
            }
            System.out.println("Seçtiğiniz yerdeki harf="+kartlar[c][d].getDeger());
            if(a==c&&b==d){
                System.out.println("Lütfen farklı sayilar kullanın.");
                continue;
            }
            System.out.println("Giridiğiniz yerlerdeki karakterler kontrol ediliyor..."+kontrolet(a,b,c,d));
            if (kontrolet(a,b,c,d).equals("Tebrikler Doğru Tahmin.")){
                System.out.println("Oyun tahtasında yeni yerleri açtınız.");
                oyuntahtasi();
            }
            else{
                System.out.println("Yeni yer açamadınız.");
            }
            if (oyunbittimi()){
                    break;
            }
            hak++;

        }
    }
    public static String kontrolet(int a,int b,int c,int d){
        if(kartlar[a][b].getDeger()==kartlar[c][d].getDeger()){
            kartlar[a][b].setTahmin(true);
            kartlar[c][d].setTahmin(true);
            return "Tebrikler Doğru Tahmin.";
        }
        else return "Yanlış Tahmin.";
    }
    public static void oyuntahtasi(){
        System.out.println("----------------------------");
        for (int i=0;i<kartlar.length;i++){
            for (int j=0;j< kartlar[1].length;j++) {
                if (kartlar[i][j].isTahmin()){
                    System.out.print("|   "+kartlar[i][j].getDeger()+"   |");
                }
                else{
                    System.out.print("|     |");
                }
            }
            System.out.println("\n----------------------------");
        }
    }
    public static boolean oyunbittimi(){
        int i,j;
        for(i=0;i< kartlar.length;i++){
            for(j=0;j<kartlar[1].length;j++){
                if(kartlar[i][j].isTahmin()){
                    continue;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}