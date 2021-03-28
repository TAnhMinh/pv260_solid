
package pv260.solid.dip.original;


public class Main {

    public static void main(String[] args) throws Exception {
        RecomendedOutfitService outfitService = new RecomendedOutfitService(new OpenWeatherMapService());
        RecommendedLunchService lunchService = new RecommendedLunchService(new DarkSkyForecastService());
        System.out.println("o--         Awesome Lifestyle Page               --o");
        System.out.println("Tomorrow, it would be wise to dress like this:");
        System.out.println(outfitService.recomendOutfitForTomorrow());
        System.out.println("For luch, we recomend that you:");
        System.out.println(lunchService.recomendLunchForTomorrow());
        System.out.println("o--                                              --o");
    }

}
