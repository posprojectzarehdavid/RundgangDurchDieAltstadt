package com.example.monkeyman.rundgangdurchdiealtstadt;

import java.lang.reflect.Field;
import java.util.HashMap;

/**
 * Created by David A on 14.12.2016.
 */
public class SehenwuerdigkeitenTexte {
    public static HashMap<String, String> deutscheTexte = new HashMap<>();
    public static HashMap<String, String> englischeTexte = new HashMap<>();

    public void InitLists() {
        Field[] fields = SehenwuerdigkeitenTexte.class.getDeclaredFields();
        for (Field field : fields) {
            try {
                if (field.getName().endsWith("_d"))
                    deutscheTexte.put(field.getName().toLowerCase(), field.get(this).toString());
                else if (field.getName().endsWith("_e"))
                    englischeTexte.put(field.getName().toLowerCase(), field.get(this).toString());
            } catch (IllegalAccessException ex) {
                System.out.println(ex);
            }
        }
    }

    public final String s1_d = "Geschaffen 1963 von Prof. Hans Wimmer, München. Das große " +
            "Becken symbolisiert den Wasserreichtum Schärdings, die Schifffahrt, " +
            "den elektrischen Strom der Innkraftwerke und die Kalt- und Warmwasserkuren, " +
            "aber auch die Hochwassergefahr, " +
            "der die Stadt immer " +
            "wieder ausgesetzt ist. ";

    public final String s1_e = "Created in 1963 by Prof. Hans Wimmer of Munich, this fountain symbolizes " +
            "just how important water still is to the town of Schärding. And " +
            "not just the health-giving waters of its springs or even the navigable " +
            "waters of the Inn - which these days are used for power generation too. " +
            "The fountain also reminds us of the ever present danger of flooding, " +
            "should the Inn burst its banks.";

    public final String s2_d = "Nord-Ost-Seite des Oberen Stadtplatzes, wahrscheinlich so genannt " +
            "wegen der reichen Kaufleute, die einst hier ihren Sitz hatten, als der " +
            "Inn noch eine bedeutende Handelsstraße war. Die bunten Fassaden " +
            "mit pastellfarbenen Farbtönen gehen auf die mittelalterlichen " +
            "Zunftfarben " +
            "zurück, die einzelnen Zünften zugeordnet " +
            "waren (zB. Bäcker " +
            "blau, Metzger rot, Gastwirte gelb u. grün). ";

    public final String s2_e = "The north-east side of the Upper Place is thought to owe its name - " +
            "which means „silver row“ - to the rich merchants who lived there in the " +
            "days when the Inn was an important trade route. The colorful facades " +
            "with their pastel shades go right back to the medieval guild colors that " +
            "were attributed to the various trades (e.g. blue for bakers, red for butchers " +
            "and yellow and green for innkeepers).";

    public final String s3_d = "Ehemaliger Oberer Stadtturm, der vom Türmer bewohnt wurde. " +
            "Ein Doppeltor am Beginn der Linzer Straße.";
    ;

    public final String s3_e =
            "Formerly the gateway to the upper town and home to the town‘s " +
                    "watchmen, this double-arched gate now marks the beginning of the " +
                    "Linzer Straße.";

    public final String s4_d = "War ursprünglich das Rathaus, dann städtische Getreideschranne " +
            "und Stadtfron, 1809 abgebrannt, ab 1824 in Privatbesitz und in der " +
            "heutigen Form errichtet. Städtebaulich fungiert das Gebäude " +
            "als Trennung " +
            "zwischen dem Oberen und dem Unteren Stadtplatz. " +
            "Das Fresko " +
            "(eine Frau mit einer Sparkasse, darunter ein tanzendes Innviertler Paar) " +
            "stammt von Prof. Fritz Fröhlich (Linz, 1952). ";

    public final String s4_e =
            "This was where the town hall once stood, although by the time it burned " +
                    "down in 1809, it had already been converted into a granary. The " +
                    "property passed into private hands in 1824, when it was rebuilt in " +
                    "its current form. Besides marking the border between the upper and " +
                    "lower town squares, the house is also remarkable " +
                    "on account of a fresco " +
                    "painted by Prof. Fritz Fröhlich of Linz in 1952.";

    public final String s5_d = "An die Zeit des ersten Kirchenbaues um 1307 erinnert die Torhalle, die " +
            "man durch das Turmportal betritt. 1703 wurde die gotische Pfarrkirche " +
            "St. Georg im Zuge des Spanischen Erbfolgekrieges schwer beschädigt " +
            "und um 1725 vom Passauer Dombaumeister Jakob Pawagner im Barock " +
            "aufgebaut. Der Münchner Johann Michael Fischer stellte den Bau " +
            "fertig. Durch die französische Beschießung " +
            "1809 brannte sie aus und " +
            "wurde 1814 wieder hergestellt. Umfassende Innenrenovierung seit " +
            "1975. ";

    public final String s5_e =
            "The first church on this site was erected in 1307, but all that remains of " +
                    "it now is the vestibule entered through the tower portal. In 1725, having " +
                    "been severely damaged during the War of the Spanish Succession " +
                    "in 1703, the church was rebuilt in the Baroque style by Jakob Pawagner, " +
                    "the architect who designed Passau Cathedral. It was completed by " +
                    "Johann Michael Fischer of Munich and although severely damaged by " +
                    "a French artillery attack in 1809, was once again rebuilt just five years " +
                    "later. The interior was renovated in 1975.";

    public final String s6_d = "Als Stiftung mit dem ehemaligen Bürgerspital 1498 vollendet und " +
            "1809 völlig ausgebrannt. Später als Hufschmiede verwendet. 1961 restauriert, " +
            "beherbergt jetzt ein Hotel. Das Portal mit reichprofiliertem " +
            "Rotmarmorgewände und dem Relief im Bogenfeld ist als Meisterwerk " +
            "spätgotischer Steinbildhauerarbeit " +
            "das wertvollste gotische Bauwerk " +
            "der Stadt. ";
    public final String s6_e =
            "Originally built for the former Bürgerspital in 1498, this church was also " +
                    "destroyed in 1809 and in the years thereafter was used as a blacksmith‘s " +
                    "shop. Having been extensively restored in 1961, it now houses a hotel. " +
                    "The portal with its red marble mouldings and relief work underneath " +
                    "the arch is a masterpiece of Late Gothic stonemasonry and Schärding‘s " +
                    "best example of Gothic architecture.";

    public final String s7_d = "Georg Wieninger (1859-1925), Brauerei- und Realitätenbesitzer, " +
            "wirkte bahnbrechend für die Entwicklung der heimischen Landwirtschaft, " +
            "Gründer der ersten Teebutter-Verkaufsgenossenschaft, " +
            "später " +
            "„Schärdinger Molkereiverband“. ";
    public final String s7_e =
            "As a landowner and proprietor of one of the local breweries, Georg " +
                    "Wieninger (1859-1925) was a pioneer of local agriculture. It was he " +
                    "who founded the first butter vending cooperative that would later become " +
                    "Schärdinger Associated Dairies.";


    public final String s8_d = "Auch Allerheiligentor genannt, hatte ursprünglich einen gotischen " +
            "Spitzturm, wurde 1984 umgestaltet. ";
    public final String s8_e =
            "Also known as All Saints‘ Gate, this gate originally had a Gothic spire " +
                    "that was removed in 1984.";

    public final String s9_d = "Leonhard Kaiser, ca. 1480 in Raab geboren, war katholischer Priester. " +
            "Trotz Verbots predigte Kaiser als Anhänger Luthers die reformatorischen " +
            "Ideen im Innviertel. Da er nicht widerrufen wollte, wurde er am " +
            "16.8.1527 an dieser Stelle (damals „am Sand“) als Ketzer verbrannt. ";
    public final String s9_e =
            "Born in 1480 Leonhard Kaiser was a Catholic priest who became a " +
                    "follower of Luther. He was not allowed by the Church to communicate " +
                    "Luther’s ideas to the inhabitantsof our region. When he refused to renounce " +
                    "Luther’s religions philosophy he was burnt at the stoke as a " +
                    "heretic in 1527.";

    public final String s10_d = "Start der beliebten Innschifffahrt durch das wildromantische Untere " +
            "Inntal zwischen Schärding und Passau/Ingling. ";
    public final String s10_e =
            "From here, you can take a boat trip along the wildly romantic Inn valley " +
                    "as far as Passau/Ingling.";

    public final String s11_d = "Benannt nach Ludwig Götz, der 1844 den Turm kaufte und zum Wohnhaus " +
            "umbaute; heute wieder im Besitz der Stadtgemeinde. ";
    public final String s11_e =
            "This tower is named after Ludwig Götz, who bought it in 1844 and " +
                    "converted it into a private dwelling. It now belongs to the town.";

    public final String s12_d = "Die Zeichnung von Johann Lamprecht (1816 – 1895) links gibt einen " +
            "Eindruck von der gewaltigen früheren Burganlage, die von den bayerischen " +
            "Herzögen Albrecht I. und Ludwig VII., dem Gebarteten, im 14. " +
            "und 15. Jahrhundert zu einer bedeutenden Landesfestung ausgebaut " +
            "wurde. Im 16. und 17. Jahrhundert erlebte das mächtige Hochschloss " +
            "mit dem imposanten Burgfried seine Hochblüte. Es wurde jedoch " +
            "durch Brände in den Jahren 1724 und 1775 fast vollständig zerstört " +
            "und nicht wieder aufgebaut. " +
            "Das rechte Bild stammt aus dem Jahr 1499 und zeigt den Innenhof der " +
            "mittelalterlichen Burg. Einzig die halbrunde Ringmauer und das 2003 " +
            "rekonstruierte Brunnenhaus erinnern noch an das gotische Schloss. " +
            "Beide Bilddokumente und andere alte Kupferstiche bildeten die Grundlage " +
            "für die Erstellung eines naturalistischen Burgmodells im Frühjahr " +
            "2013, welches vom Restaurator Hartmut Weinast in den Ausmaßen " +
            "190 x 130 x 70 cm angefertigt wurde und im 1. Stock des Granitmuseums " +
            "neben dem Wassertor jeweils von April bis Oktober kostenlos " +
            "zu besichtigen ist. " +
            "Geschichte Burgbrunnen: Am 26. Jänner 1499 ist die elfjährige Tochter " +
            "des damaligen Burgverwalters Ritter Bernhard von Seyboltstorf beim " +
            "Spielen in den Brunnen gefallen und konnte durch einen hinunter gelassenen " +
            "Burgknecht gerettet werden. Zum Dank für die Rettung, die " +
            "auch auf die Hilfe der Gottesmutter Maria zurückgeführt wurde, hat " +
            "man ein Bild angefertigt, das den Brunnen in seinem Originalzustand " +
            "zeigt. ";


    public final String s12_e =
            "The drawing by Johann Lamprecht (1816 – 1895) on the left-hand side gives the " +
                    "viewer an idea of the sheer vastness and enormity of this former castle complex " +
                    "which was developed into an important state fortress by the Bavarian dukes Albrecht " +
                    "I. and Louis VII The Bearded in the 14th and 15th Century, respectively. The " +
                    "powerful high castle with its imposing keep saw its heyday in the 16th and 17th " +
                    "Century. Unfortunately, it was nearly completely destroyed by the fires of 1724 " +
                    "and 1775 and was never rebuilt. The drawing on the right-hand side dates from " +
                    "the year 1499 and shows the inner courtyard of the medieval castle. The only " +
                    "remnants still recalling the grandeur of this Gothic castle are the semi-circular " +
                    "curtain wall and the well house, which was reconstructed in 2003. " +
                    "It was these two historical drawings, as well as a number of antique copperplate " +
                    "engravings, which served as basis for the naturalistic castle model recreated in " +
                    "the spring of 2013 by art restorer Hartmut Weinast at the size of 190x130x70 " +
                    "centimeters, and exhibited free of charge on the 1st floor of the Granite Museums " +
                    "next to the Water Gate during the April-October season. " +
                    "History of the Castle Well: On January 26, 1499, the eleven-year old daughter of " +
                    "the then castle warden, Knight Bernhard von Seyboltstorf, fell into the well shaft " +
                    "while playing, and was saved by a castle servant lowered down on a rope. As a " +
                    "sign of gratitude for this miraculous rescue, which was also attributed to the divine " +
                    "intervention by the Blessed Virgin Mary, a picture was commissioned which " +
                    "shows the well in its original condition.";

    public final String s13_d = "Früher Inntor oder Zollturm genannt, bis 1570 herzoglich-bayerisches " +
            "Landeseigentum, anschließend im Besitz der Stadt, seit 1819 privat; " +
            "stadtseitig schließt das Tor mit einer geraden Wandfläche ab, auf der " +
            "ein Fresko an die Beschießung der Stadt durch die dänischen und österreichischen " +
            "Truppen im Spanischen Erbfolgekrieg 1703 erinnert. Zahlreiche " +
            "Hochwassermarken " +
            "berichten von den Überschwemmungskatastrophen. " +
            "Der quergesetzte Söller oberhalb des Bogens diente als " +
            "Pranger, wo Verurteilte zur Schau gestellt wurden. Beherbergt heute " +
            "ein Restaurant und Museumsräumlichkeiten. ";
    public final String s13_e =
            "Until 1570, the gate that used to be called the Inn Gate or Customs " +
                    "Tower belonged to the Dukes of Bavaria. It then fell to the town before " +
                    "passing into private hands in 1819. The town side of the tower " +
                    "features a fresco depicting the bombardment of Schärding by Danish " +
                    "and Austrian troops during the War of the Spanish Succession in 1703. " +
                    "The countless high-water marks meanwhile tell their own story of the " +
                    "town‘s numerous flood disasters. The balcony in the corner above the " +
                    "arch was originally used to pillory convicted criminals. It now houses a " +
                    "restaurant and a museum.";

    public final String s14_d = "Das ehemals gotische Wasserschloss brannte 1724 ab, wurde 1752 " +
            "barock aufgebaut, um 1900 mit Kirche und rechtem Trakt erweitert " +
            "und " +
            "ist heute Kloster und Realschule der Englischen Fräulein. ";

    public final String s14_e =
            "The original Gothic palace burned down in 1724, but was rebuilt in " +
                    "the Baroque style 28 years later. The church and right-hand tract were " +
                    "added in 1900. The building is now used as a convent and school.";

    public final String s15_d = "1607 aus Granit geschaffen; bis 1884 hatte er seinen Standort auf dem " +
            "Oberen Stadtplatz. Ursprünglich stand hier der St.-Florian-Brunnen, " +
            "dessen barocke Statue jetzt im Schlosspark " +
            "aufgestellt ist. ";
    public final String s15_e =
            "Carved out of solid granite in 1607, this fountain was situated on the " +
                    "Upper Place until 1884. The Baroque statuary of the St.-Florian-Brunnen " +
                    "that preceded it at this site can now be viewed in the Castle Park.";

    public final String s16_d = "“Heuchler, zieh’ zuvor den Balken aus deinem Auge, dann magst du " +
            "sehen, wie du den Splitter aus deines Bruders Auge ziehst. Luc. VI, 42.” " +
            "Mit diesem als Trutzbild geschaffenen Fresko wollte sich der einstige " +
            "Besitzer an den Ratsherren rächen, die in einem Rechtsstreit bei ihm " +
            "alle Schuld suchten, ihre eigenen Fehler aber nicht sehen wollten. ";
    public final String s16_e =
            "„You hypocrite, first take the log out of your own eye, and then you " +
                    "will see clearly to take out the speck that is in your brother‘s eye“ (Luke " +
                    "6, 42). Heartily fed up with the town councillors for litigating against " +
                    "him, while at the same time refusing to admit to their own mistakes, " +
                    "the erstwhile owner of this house took revenge by adorning his house " +
                    "with this fresco.";

    public final String s17_d = "Es wurde 1594 aus zwei aufgekauften Bürgerhäusern errichtet. Nach " +
            "Brandschäden von 1809 mehrmaliger Umbau in Neugotik und Neubarock. " +
            "Im Rathaussaal im ersten Stock befinden sich Fresken von Prof. " +
            "Zülow (Linz, 1947) mit charakteristischen Motiven der Altstadt. ";
    public final String s17_e =
            "Schärding‘s town hall dates back to 1594, when two patrician‘s houses " +
                    "were joined together to create a new Rathaus. Having suffered severe " +
                    "fire damage in 1809, it was restyled several times in the Neo-Gothic " +
                    "and Neo-Baroque styles. The Council Room on the first floor contains " +
                    "frescos by Prof. Zülow of Linz (1947) depicting motifs characteristic of " +
                    "the old town.";

    public final String s18_d = "Früher Wohnung des herzoglichen Burghüters, heute Heimathaus " +
            "und " +
            "Stadtmuseum. Bis 1809 nur über eine Brücke über den damals äußeren " +
            "Burggraben erreichbar. " +
            "Der rückwärtige ältere Teil aus Tuffstein bildete " +
            "den äußeren Burgturm und hatte einst vier Stockwerke. Er geht auf die " +
            "Wehranlagen zurück, die Herzog Ludwig der Gebartete 1428 - 1436 " +
            "errichten ließ. ";
    public final String s18_e =
            "Once home to the guards of the ducal palace, this castle gate now houses " +
                    "Schärding‘s local museum. Until 1809, it was accessible only via a " +
                    "bridge across the outer moat. The older part of the building at the rear " +
                    "was originally four storeys high. Made of tuff, it was once the outermost " +
                    "tower of the fortress built for Duke Ludwig the Bearded between 1428 " +
                    "and 1436.";

    public final String s19_d = "Der nach Plänen der Architekten Schaffer und Sturm (Linz-Hörsching) " +
            "1997 erbaute und nach dem heimischen Grafiker Alfred Kubin benannte " +
            "Saal fasst ca. 300 Personen und wird für Veranstaltungen verschiedenster " +
            "Art verwendet. Planungsvorgabe " +
            "war ein Teil der von der " +
            "alten historischen Stadtbefestigung " +
            "stammenden Ringmauer, welcher " +
            "im ursprünglichen (unverputzten) Zustand die Bühnenrückwand " +
            "bildet. ";
    public final String s19_e =
            "Designed by the architects Schaffer und Sturm of Linz-Hörsching, the " +
                    "Kubinsaal built in 1997 is named after the artist, Alfred Kubin, who was " +
                    "a native of Schärding. With room for some 300 people, the Kubinsaal " +
                    "is used for a variety of cultural events as well as business functions. As " +
                    "the contract required the architects to include in their plans part of the " +
                    "town‘s medieval fortifications, the old town wall - still without rendering " +
                    "- now serves as a backdrop for the stage.";

    public final String s20_d = "Der ehemalige Burghof wurde 1895 zu einer Parkanlage umgestaltet. " +
            "An der Stelle des jetzigen Aussichtspavillons war früher der „ Pallas“, " +
            "das repräsentative Wohngebäude der Burg. Im kleinen Barockgärtlein " +
            "steht die Statue des heiligen Florian aus dem 17. Jahrhundert. Im Norderker " +
            "erinnert ein Kanonennachbau an die oftmaligen Verteidigungskämpfe " +
            "der Stadt. An der inneren Ringmauer erinnert eine Gedenktafel " +
            "an den „Frieden zu Schärding 1369“, durch welchen die Zugehörigkeit " +
            "der Stadt zu Bayern manifestiert wurde. ";

    public final String s20_e =
            "In 1895, the former castle courtyard was redesigned into a park. What " +
                    "is now the observation pavilion used to be the “Pallas“, i.e. the castle’s " +
                    "prestigious residential building. The little Baroque garden boasts a statue " +
                    "of Saint Florian dating from the 17th Century. Another realistic recreation, " +
                    "this time of a war cannon in the castle’s northern jutty, recalls " +
                    "the city’s history of frequent defense battles. On the inner ring wall, " +
                    "a commemorative plaque recalls the “Schärding Peace Agreement of " +
                    "1369“, a historical event marking the town’s falling to what was then " +
                    "the Kingdom of Bavaria.";
    public final String s21_d = "Der 26 m tiefe, aus dem Granit gemeißelte Brunnen wurde 2003 wieder " +
            "entdeckt. Er stammt vom Bau der Burg im Jahr 1225. Das Brunnenhaus " +
            "wurde nach einem Votivbild von 1499 rekonstruiert. ";
    public final String s21_e =
            "This 26m deep well was rediscovered in 2003. Chiseled out of the " +
                    "granite, it dates from the construction of the castle in the year 1225. " +
                    "The well-house has been reconstructed according to a votive painting " +
                    "dating from 1499.";

    public final String s22_d = "Laut Chronist Lamprecht stammen die elf Pfeiler aus dem Jahre 1310; " +
            "sie wurden damals auf Granitfelsen im Flussbett errichtet. Beim Katastrophenhochwasser " +
            "1899 wurde die gesamte Holzfahrbahn " +
            "weggerissen. " +
            "Nach dem 2. Weltkrieg erhielt die 250 m lange Brücke eine " +
            "Eisenbetonkonstruktion. ";
    public final String s22_e =
            "According to the historian, Lamprecht, the eleven-pier bridge dating " +
                    "from 1310 was erected on granite rocks on the bed of the river. However " +
                    "it was in 1899 that catastrophically high floodwaters swept the " +
                    "whole of the wooden decking away. After the Second World War, the " +
                    "250m long bridge was rebuilt in reinforced concrete.";

    public final String s23_d = "1958 von Prof. Walter Ritter (Linz) geschaffen. Stellt die Schrecken des " +
            "Krieges in der Gestalt eines der apokalyptischen Reiter aus der Geheimen " +
            "Offenbarung des Johannes dar. ";
    public final String s23_e =
            "Created by Prof. Walter Ritter of Linz in 1958, this war memorial uses " +
                    "one of the Riders of the Apocalypse from the Revelation of St. John to " +
                    "symbolize the horrors of war.";

    public final String s24_d = "Es steht auf einem kleinen Hügel im Eichbüchl. " +
            "1635 - 1638 entstand hier ein Kapuzinerkloster mit Kirche. Um 1800 " +
            "Aufhebung des Klosters; 1814 wurde das Gebäude zum Amtshaus " +
            "umgebaut und 1928 durch den Konvent der Barmherzigen Brüder angekauft, " +
            "der an dessen Stelle die Kuranstalt errichtete. Die ehemalige " +
            "Kapuzinerkirche wurde zur Kurhauskirche umgestaltet. Das Bild an " +
            "der Langhauswand zeigt im unteren Teil einen Ausschnitt der Stadt mit " +
            "ausgebrannter Burg, dem Brückentor, einem Teil der Brücke und dem " +
            "Eichbüchl mit Sebastianskirche, Kapuzinerkloster und Stadtmauer, " +
            "gemalt " +
            "1738 von Michelangelo Unterberger. Die lebensgroßen barocken " +
            "Heiligenstatuen stammen aus der Wiener Rochuskirche. ";

    public final String s24_e =
            "Schärding‘s Kneipp Health Resort, which was originally a Cistercian " +
                    "Monastery built in 1635-1638, is situated on a small hill in the Eichbüchl. " +
                    "Following the dissolution of the monastery around 1800, the " +
                    "building was converted into government offices, but in 1928 was " +
                    "purchased by the Order of Merciful Brothers, who used the site to erect " +
                    "today‘s Kurhaus and henceforth used the old Cistercian church as the " +
                    "Kurhaus church.";

    public final String s25_d = "Bevor Sie zur Station 26 weitergehen, machen Sie einen kurzen Abstecher " +
            "ins Eichbüchl und werfen einen Blick auf den Barockgarten " +
            "Orangerie. An der alten Stadtmauer wurde 1884 von Georg Wieninger " +
            "ein Gewächshaus mit Gärtnerwohnung liebevoll errichtet, das 2004 " +
            "revitalisiert wurde und heute ein Restaurant – inmitten einer herrlichen " +
            "Parkanlage – beherbergt. ";

    public final String s25_e =
            "Along the old town wall, Georg Wieninger built a greenhouse with " +
                    "lovely decorated apartments for the gardeners that was renovated in " +
                    "2004 and is now a restaurant surrounded by a wonderful " +
                    "park. Before " +
                    "you continue to station 26, make a short stop at Eichbüchl and have a " +
                    "look at the Baroque garden Orangerie.";

    public final String s26_d = "Sebastianskirche oder Kirche am Stein (steht auf einem Granitfelsen), " +
            "erbaut zu Ehren der Pest- und Seuchenheiligen Sebastian und Rochus " +
            "zur Abwendung der Seuche um 1630. 1783 profaniert, später Theater " +
            "und Lagerraum. Nach sorgfältiger Restaurierung seit 1954 evangelische " +
            "Pfarrkirche. ";

    public final String s26_e =
            "The Church of St. Sebastian, also known as the Church on the Rock " +
                    "(situated on a solid block of granite) was originally built in 1630 in " +
                    "honour of both St. Sebastian und St. Rochus. These are the saints of " +
                    "all those afflicted by disease. This dedication was made in hope of " +
                    "averting the fast - approaching plague. After deconsecreation in 1738 " +
                    "it was used as a theatre and warehouse. It was eventually restored and " +
                    "reconsecrated as a Protestant parish Church in 1954.";

    public final String s27_d = "1695 in dieser Grundform als Wohnhaus des Großhändlers Andreas " +
            "Schacky erbaut, nach 1782 Kastenamt, 1816 K.K. Land- und Pflegegericht " +
            "und seit 1854 Bezirksamt bzw. Bezirkshauptmannschaft. " +
            "Die heutige klassizistische Gestalt erhielt das Gebäude nach Bränden " +
            "von 1779 und 1809. ";
    public final String s27_e =
            "Built in 1695 as a private residence for the merchant, Andreas Schacky, " +
                    "this building has long since served as government offices. It began its " +
                    "official career as a land registry in 1782, but was later recast as an Austro- " +
                    "Hungarian court for land disputes and did not become the district " +
                    "commissioner‘s office it still is today until 1854. The Classical façade " +
                    "was added after the fires of 1779 and 1809.";

    public final String s28_d = "Die Türme entlang des Grabens deuten auf das ehemalige befestigte " +
            "Aussehen hin. Die Mauer selbst war höher und mit Zinnen versehen. " +
            "Die Rückfronten der Häuser der Silberzeile tragen hier einfache Spitzgiebeln. ";
    public final String s28_e =
            "The towers along the moat are reminders of its original purpose as part " +
                    "of the town‘s defences. The wall used to have ramparts and was of " +
                    "course much higher than it is now. The gables visible here are the rear " +
                    "gables of the picturesque houses along the Silberzeile.";
}
