package com.example.monkeyman.rundgangdurchdiealtstadt;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by David A on 14.12.2016.
 */
public class SehenwuerdigkeitenTexte {
    public static ArrayList<String>deutscheTexte = new ArrayList<>();
    public static ArrayList<String>englischeTexte = new ArrayList<>();

    public static void InitLists(){
        Field[] fields = Sehenswuerdigkeit.class.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if(fields[i].getName().endsWith("_d")) deutscheTexte.add(fields[i].toString());
            else if(fields[i].getName().endsWith("_e")) englischeTexte.add(fields[i].toString());

        }
    }

    public final String Christophorusbrunnen_d = "Geschaffen 1963 von Prof. Hans Wimmer, München. Das große\n" +
            "Becken symbolisiert den Wasserreichtum Schärdings, die Schifffahrt,\n" +
            "den elektrischen Strom der Innkraftwerke und die Kalt- und Warmwasserkuren,\n" +
            "aber auch die Hochwassergefahr,\n" +
            "der die Stadt immer\n" +
            "wieder ausgesetzt ist.\n";

    public final String Christophorusbrunnen_e = "Created in 1963 by Prof. Hans Wimmer of Munich, this fountain symbolizes\n" +
            "just how important water still is to the town of Schärding. And\n" +
            "not just the health-giving waters of its springs or even the navigable\n" +
            "waters of the Inn - which these days are used for power generation too.\n" +
            "The fountain also reminds us of the ever present danger of flooding,\n" +
            "should the Inn burst its banks.";

    public final String SILBERZEILE_d = "Nord-Ost-Seite des Oberen Stadtplatzes, wahrscheinlich so genannt\n" +
            "wegen der reichen Kaufleute, die einst hier ihren Sitz hatten, als der\n" +
            "Inn noch eine bedeutende Handelsstraße war. Die bunten Fassaden\n" +
            "mit pastellfarbenen Farbtönen gehen auf die mittelalterlichen\n" +
            "Zunftfarben\n" +
            "zurück, die einzelnen Zünften zugeordnet\n" +
            "waren (zB. Bäcker\n" +
            "blau, Metzger rot, Gastwirte gelb u. grün).\n";

    public final String SILBERZEILE_e = "The north-east side of the Upper Place is thought to owe its name -\n" +
            "which means „silver row“ - to the rich merchants who lived there in the\n" +
            "days when the Inn was an important trade route. The colorful facades\n" +
            "with their pastel shades go right back to the medieval guild colors that\n" +
            "were attributed to the various trades (e.g. blue for bakers, red for butchers\n" +
            "and yellow and green for innkeepers).";

    public final String LINZER_TOR_d = "Ehemaliger Oberer Stadtturm, der vom Türmer bewohnt wurde.\n" +
            "Ein Doppeltor am Beginn der Linzer Straße.";
            ;

    public final String LINZER_TOR_e =
            "Formerly the gateway to the upper town and home to the town‘s\n" +
            "watchmen, this double-arched gate now marks the beginning of the\n" +
            "Linzer Straße.";

    public final String SPARKASSE_d = "War ursprünglich das Rathaus, dann städtische Getreideschranne\n" +
            "und Stadtfron, 1809 abgebrannt, ab 1824 in Privatbesitz und in der\n" +
            "heutigen Form errichtet. Städtebaulich fungiert das Gebäude\n" +
            "als Trennung\n" +
            "zwischen dem Oberen und dem Unteren Stadtplatz.\n" +
            "Das Fresko\n" +
            "(eine Frau mit einer Sparkasse, darunter ein tanzendes Innviertler Paar)\n" +
            "stammt von Prof. Fritz Fröhlich (Linz, 1952).\n";

    public final String SPARKASSE_e =
            "This was where the town hall once stood, although by the time it burned\n" +
            "down in 1809, it had already been converted into a granary. The\n" +
            "property passed into private hands in 1824, when it was rebuilt in\n" +
            "its current form. Besides marking the border between the upper and\n" +
            "lower town squares, the house is also remarkable\n" +
            "on account of a fresco\n" +
            "painted by Prof. Fritz Fröhlich of Linz in 1952.";

    public final String STADT_PFARRKIRCHE_d = "An die Zeit des ersten Kirchenbaues um 1307 erinnert die Torhalle, die\n" +
            "man durch das Turmportal betritt. 1703 wurde die gotische Pfarrkirche\n" +
            "St. Georg im Zuge des Spanischen Erbfolgekrieges schwer beschädigt\n" +
            "und um 1725 vom Passauer Dombaumeister Jakob Pawagner im Barock\n" +
            "aufgebaut. Der Münchner Johann Michael Fischer stellte den Bau\n" +
            "fertig. Durch die französische Beschießung\n" +
            "1809 brannte sie aus und\n" +
            "wurde 1814 wieder hergestellt. Umfassende Innenrenovierung seit\n" +
            "1975.\n";

    public final String STADT_PFARRKIRCHE_e =
            "The first church on this site was erected in 1307, but all that remains of\n" +
            "it now is the vestibule entered through the tower portal. In 1725, having\n" +
            "been severely damaged during the War of the Spanish Succession\n" +
            "in 1703, the church was rebuilt in the Baroque style by Jakob Pawagner,\n" +
            "the architect who designed Passau Cathedral. It was completed by\n" +
            "Johann Michael Fischer of Munich and although severely damaged by\n" +
            "a French artillery attack in 1809, was once again rebuilt just five years\n" +
            "later. The interior was renovated in 1975.";

    public final String EHEMALIGES_SPITAL_d = "Als Stiftung mit dem ehemaligen Bürgerspital 1498 vollendet und\n" +
            "1809 völlig ausgebrannt. Später als Hufschmiede verwendet. 1961 restauriert,\n" +
            "beherbergt jetzt ein Hotel. Das Portal mit reichprofiliertem\n" +
            "Rotmarmorgewände und dem Relief im Bogenfeld ist als Meisterwerk\n" +
            "spätgotischer Steinbildhauerarbeit\n" +
            "das wertvollste gotische Bauwerk\n" +
            "der Stadt.\n";
    public final String EHEMALIGES_SPITAL_e =
            "Originally built for the former Bürgerspital in 1498, this church was also\n" +
            "destroyed in 1809 and in the years thereafter was used as a blacksmith‘s\n" +
            "shop. Having been extensively restored in 1961, it now houses a hotel.\n" +
            "The portal with its red marble mouldings and relief work underneath\n" +
            "the arch is a masterpiece of Late Gothic stonemasonry and Schärding‘s\n" +
            "best example of Gothic architecture.";

    public final String GEORG_WIENINGER_STRASSE_d = "Georg Wieninger (1859-1925), Brauerei- und Realitätenbesitzer,\n" +
            "wirkte bahnbrechend für die Entwicklung der heimischen Landwirtschaft,\n" +
            "Gründer der ersten Teebutter-Verkaufsgenossenschaft,\n" +
            "später\n" +
            "„Schärdinger Molkereiverband“.\n";
    public final String GEORG_WIENINGER_STRASSE_e =
            "As a landowner and proprietor of one of the local breweries, Georg\n" +
            "Wieninger (1859-1925) was a pioneer of local agriculture. It was he\n" +
            "who founded the first butter vending cooperative that would later become\n" +
            "Schärdinger Associated Dairies.";


    public final String PASSAUER_TOR_d = "Auch Allerheiligentor genannt, hatte ursprünglich einen gotischen\n" +
            "Spitzturm, wurde 1984 umgestaltet.\n";
    public final String PASSAUER_TOR_e =
            "Also known as All Saints‘ Gate, this gate originally had a Gothic spire\n" +
            "that was removed in 1984.";

    public final String LEONHARD_KAISER_DENKMAL_d = "Leonhard Kaiser, ca. 1480 in Raab geboren, war katholischer Priester.\n" +
            "Trotz Verbots predigte Kaiser als Anhänger Luthers die reformatorischen\n" +
            "Ideen im Innviertel. Da er nicht widerrufen wollte, wurde er am\n" +
            "16.8.1527 an dieser Stelle (damals „am Sand“) als Ketzer verbrannt.\n";
    public final String LEONHARD_KAISER_DENKMAL_e =
            "Born in 1480 Leonhard Kaiser was a Catholic priest who became a\n" +
            "follower of Luther. He was not allowed by the Church to communicate\n" +
            "Luther’s ideas to the inhabitantsof our region. When he refused to renounce\n" +
            "Luther’s religions philosophy he was burnt at the stoke as a\n" +
            "heretic in 1527.";

    public final String SCHIFFSANLEGESTELLE_d = "Start der beliebten Innschifffahrt durch das wildromantische Untere\n" +
            "Inntal zwischen Schärding und Passau/Ingling.\n";
    public final String SCHIFFSANLEGESTELLE_e =
            "From here, you can take a boat trip along the wildly romantic Inn valley\n" +
            "as far as Passau/Ingling.";

    public final String GOETZTURM_d = "Benannt nach Ludwig Götz, der 1844 den Turm kaufte und zum Wohnhaus\n" +
            "umbaute; heute wieder im Besitz der Stadtgemeinde.\n";
    public final String GOETZTURM_e =
            "This tower is named after Ludwig Götz, who bought it in 1844 and\n" +
            "converted it into a private dwelling. It now belongs to the town.";

    public final String BURG_MODELL_d = "Die Zeichnung von Johann Lamprecht (1816 – 1895) links gibt einen\n" +
            "Eindruck von der gewaltigen früheren Burganlage, die von den bayerischen\n" +
            "Herzögen Albrecht I. und Ludwig VII., dem Gebarteten, im 14.\n" +
            "und 15. Jahrhundert zu einer bedeutenden Landesfestung ausgebaut\n" +
            "wurde. Im 16. und 17. Jahrhundert erlebte das mächtige Hochschloss\n" +
            "mit dem imposanten Burgfried seine Hochblüte. Es wurde jedoch\n" +
            "durch Brände in den Jahren 1724 und 1775 fast vollständig zerstört\n" +
            "und nicht wieder aufgebaut.\n" +
            "Das rechte Bild stammt aus dem Jahr 1499 und zeigt den Innenhof der\n" +
            "mittelalterlichen Burg. Einzig die halbrunde Ringmauer und das 2003\n" +
            "rekonstruierte Brunnenhaus erinnern noch an das gotische Schloss.\n" +
            "Beide Bilddokumente und andere alte Kupferstiche bildeten die Grundlage\n" +
            "für die Erstellung eines naturalistischen Burgmodells im Frühjahr\n" +
            "2013, welches vom Restaurator Hartmut Weinast in den Ausmaßen\n" +
            "190 x 130 x 70 cm angefertigt wurde und im 1. Stock des Granitmuseums\n" +
            "neben dem Wassertor jeweils von April bis Oktober kostenlos\n" +
            "zu besichtigen ist.\n" +
            "Geschichte Burgbrunnen: Am 26. Jänner 1499 ist die elfjährige Tochter\n" +
            "des damaligen Burgverwalters Ritter Bernhard von Seyboltstorf beim\n" +
            "Spielen in den Brunnen gefallen und konnte durch einen hinunter gelassenen\n" +
            "Burgknecht gerettet werden. Zum Dank für die Rettung, die\n" +
            "auch auf die Hilfe der Gottesmutter Maria zurückgeführt wurde, hat\n" +
            "man ein Bild angefertigt, das den Brunnen in seinem Originalzustand\n" +
            "zeigt.\n";


    public final String BURG_MODELL_e =
            "The drawing by Johann Lamprecht (1816 – 1895) on the left-hand side gives the\n" +
            "viewer an idea of the sheer vastness and enormity of this former castle complex\n" +
            "which was developed into an important state fortress by the Bavarian dukes Albrecht\n" +
            "I. and Louis VII The Bearded in the 14th and 15th Century, respectively. The\n" +
            "powerful high castle with its imposing keep saw its heyday in the 16th and 17th\n" +
            "Century. Unfortunately, it was nearly completely destroyed by the fires of 1724\n" +
            "and 1775 and was never rebuilt. The drawing on the right-hand side dates from\n" +
            "the year 1499 and shows the inner courtyard of the medieval castle. The only\n" +
            "remnants still recalling the grandeur of this Gothic castle are the semi-circular\n" +
            "curtain wall and the well house, which was reconstructed in 2003.\n" +
            "It was these two historical drawings, as well as a number of antique copperplate\n" +
            "engravings, which served as basis for the naturalistic castle model recreated in\n" +
            "the spring of 2013 by art restorer Hartmut Weinast at the size of 190x130x70\n" +
            "centimeters, and exhibited free of charge on the 1st floor of the Granite Museums\n" +
            "next to the Water Gate during the April-October season.\n" +
            "History of the Castle Well: On January 26, 1499, the eleven-year old daughter of\n" +
            "the then castle warden, Knight Bernhard von Seyboltstorf, fell into the well shaft\n" +
            "while playing, and was saved by a castle servant lowered down on a rope. As a\n" +
            "sign of gratitude for this miraculous rescue, which was also attributed to the divine\n" +
            "intervention by the Blessed Virgin Mary, a picture was commissioned which\n" +
            "shows the well in its original condition.";

    public final String WASSERTOR_d = "Früher Inntor oder Zollturm genannt, bis 1570 herzoglich-bayerisches\n" +
            "Landeseigentum, anschließend im Besitz der Stadt, seit 1819 privat;\n" +
            "stadtseitig schließt das Tor mit einer geraden Wandfläche ab, auf der\n" +
            "ein Fresko an die Beschießung der Stadt durch die dänischen und österreichischen\n" +
            "Truppen im Spanischen Erbfolgekrieg 1703 erinnert. Zahlreiche\n" +
            "Hochwassermarken\n" +
            "berichten von den Überschwemmungskatastrophen.\n" +
            "Der quergesetzte Söller oberhalb des Bogens diente als\n" +
            "Pranger, wo Verurteilte zur Schau gestellt wurden. Beherbergt heute\n" +
            "ein Restaurant und Museumsräumlichkeiten.\n";
    public final String WASSERTOR_e =
            "Until 1570, the gate that used to be called the Inn Gate or Customs\n" +
            "Tower belonged to the Dukes of Bavaria. It then fell to the town before\n" +
            "passing into private hands in 1819. The town side of the tower\n" +
            "features a fresco depicting the bombardment of Schärding by Danish\n" +
            "and Austrian troops during the War of the Spanish Succession in 1703.\n" +
            "The countless high-water marks meanwhile tell their own story of the\n" +
            "town‘s numerous flood disasters. The balcony in the corner above the\n" +
            "arch was originally used to pillory convicted criminals. It now houses a\n" +
            "restaurant and a museum.";

    public final String KLOSTER_NEUHAUS_d = "Das ehemals gotische Wasserschloss brannte 1724 ab, wurde 1752\n" +
            "barock aufgebaut, um 1900 mit Kirche und rechtem Trakt erweitert\n" +
            "und\n" +
            "ist heute Kloster und Realschule der Englischen Fräulein.\n";

    public final String KLOSTER_NEUHAUS_e =
            "The original Gothic palace burned down in 1724, but was rebuilt in\n" +
            "the Baroque style 28 years later. The church and right-hand tract were\n" +
            "added in 1900. The building is now used as a convent and school.";

    public final String St_GEORGS_BRUNNEN_d = "1607 aus Granit geschaffen; bis 1884 hatte er seinen Standort auf dem\n" +
            "Oberen Stadtplatz. Ursprünglich stand hier der St.-Florian-Brunnen,\n" +
            "dessen barocke Statue jetzt im Schlosspark\n" +
            "aufgestellt ist.\n";
    public final String St_GEORGS_BRUNNEN_e =
            "Carved out of solid granite in 1607, this fountain was situated on the\n" +
            "Upper Place until 1884. The Baroque statuary of the St.-Florian-Brunnen\n" +
            "that preceded it at this site can now be viewed in the Castle Park.";

    public final String FRESKO_d = "“Heuchler, zieh’ zuvor den Balken aus deinem Auge, dann magst du\n" +
            "sehen, wie du den Splitter aus deines Bruders Auge ziehst. Luc. VI, 42.”\n" +
            "Mit diesem als Trutzbild geschaffenen Fresko wollte sich der einstige\n" +
            "Besitzer an den Ratsherren rächen, die in einem Rechtsstreit bei ihm\n" +
            "alle Schuld suchten, ihre eigenen Fehler aber nicht sehen wollten.\n";
    public final String FRESKO_e =
            "„You hypocrite, first take the log out of your own eye, and then you\n" +
            "will see clearly to take out the speck that is in your brother‘s eye“ (Luke\n" +
            "6, 42). Heartily fed up with the town councillors for litigating against\n" +
            "him, while at the same time refusing to admit to their own mistakes,\n" +
            "the erstwhile owner of this house took revenge by adorning his house\n" +
            "with this fresco.";

    public final String RATHAUS_d = "Es wurde 1594 aus zwei aufgekauften Bürgerhäusern errichtet. Nach\n" +
            "Brandschäden von 1809 mehrmaliger Umbau in Neugotik und Neubarock.\n" +
            "Im Rathaussaal im ersten Stock befinden sich Fresken von Prof.\n" +
            "Zülow (Linz, 1947) mit charakteristischen Motiven der Altstadt.\n";
    public final String RATHAUS_e =
            "Schärding‘s town hall dates back to 1594, when two patrician‘s houses\n" +
            "were joined together to create a new Rathaus. Having suffered severe\n" +
            "fire damage in 1809, it was restyled several times in the Neo-Gothic\n" +
            "and Neo-Baroque styles. The Council Room on the first floor contains\n" +
            "frescos by Prof. Zülow of Linz (1947) depicting motifs characteristic of\n" +
            "the old town.";

    public final String SCHLOSSTOR_d = "Früher Wohnung des herzoglichen Burghüters, heute Heimathaus\n" +
            "und\n" +
            "Stadtmuseum. Bis 1809 nur über eine Brücke über den damals äußeren\n" +
            "Burggraben erreichbar.\n" +
            "Der rückwärtige ältere Teil aus Tuffstein bildete\n" +
            "den äußeren Burgturm und hatte einst vier Stockwerke. Er geht auf die\n" +
            "Wehranlagen zurück, die Herzog Ludwig der Gebartete 1428 - 1436\n" +
            "errichten ließ.\n";
    public final String SCHLOSSTOR_e =
            "Once home to the guards of the ducal palace, this castle gate now houses\n" +
            "Schärding‘s local museum. Until 1809, it was accessible only via a\n" +
            "bridge across the outer moat. The older part of the building at the rear\n" +
            "was originally four storeys high. Made of tuff, it was once the outermost\n" +
            "tower of the fortress built for Duke Ludwig the Bearded between 1428\n" +
            "and 1436.";

    public final String KUBINSAAL_d = "Der nach Plänen der Architekten Schaffer und Sturm (Linz-Hörsching)\n" +
            "1997 erbaute und nach dem heimischen Grafiker Alfred Kubin benannte\n" +
            "Saal fasst ca. 300 Personen und wird für Veranstaltungen verschiedenster\n" +
            "Art verwendet. Planungsvorgabe\n" +
            "war ein Teil der von der\n" +
            "alten historischen Stadtbefestigung\n" +
            "stammenden Ringmauer, welcher\n" +
            "im ursprünglichen (unverputzten) Zustand die Bühnenrückwand\n" +
            "bildet.\n";
    public final String KUBINSAAL_e =
            "Designed by the architects Schaffer und Sturm of Linz-Hörsching, the\n" +
            "Kubinsaal built in 1997 is named after the artist, Alfred Kubin, who was\n" +
            "a native of Schärding. With room for some 300 people, the Kubinsaal\n" +
            "is used for a variety of cultural events as well as business functions. As\n" +
            "the contract required the architects to include in their plans part of the\n" +
            "town‘s medieval fortifications, the old town wall - still without rendering\n" +
            "- now serves as a backdrop for the stage.";

    public final String SCHLOSSPARK_d = "Der ehemalige Burghof wurde 1895 zu einer Parkanlage umgestaltet.\n" +
            "An der Stelle des jetzigen Aussichtspavillons war früher der „ Pallas“,\n" +
            "das repräsentative Wohngebäude der Burg. Im kleinen Barockgärtlein\n" +
            "steht die Statue des heiligen Florian aus dem 17. Jahrhundert. Im Norderker\n" +
            "erinnert ein Kanonennachbau an die oftmaligen Verteidigungskämpfe\n" +
            "der Stadt. An der inneren Ringmauer erinnert eine Gedenktafel\n" +
            "an den „Frieden zu Schärding 1369“, durch welchen die Zugehörigkeit\n" +
            "der Stadt zu Bayern manifestiert wurde.\n";

    public final String SCHLOSSPARK_e =
            "In 1895, the former castle courtyard was redesigned into a park. What\n" +
            "is now the observation pavilion used to be the “Pallas“, i.e. the castle’s\n" +
            "prestigious residential building. The little Baroque garden boasts a statue\n" +
            "of Saint Florian dating from the 17th Century. Another realistic recreation,\n" +
            "this time of a war cannon in the castle’s northern jutty, recalls\n" +
            "the city’s history of frequent defense battles. On the inner ring wall,\n" +
            "a commemorative plaque recalls the “Schärding Peace Agreement of\n" +
            "1369“, a historical event marking the town’s falling to what was then\n" +
            "the Kingdom of Bavaria.";
    public final String BURGBRUNNEN_d = "Der 26 m tiefe, aus dem Granit gemeißelte Brunnen wurde 2003 wieder\n" +
            "entdeckt. Er stammt vom Bau der Burg im Jahr 1225. Das Brunnenhaus\n" +
            "wurde nach einem Votivbild von 1499 rekonstruiert.\n";
    public final String BURGBRUNNEN_e =
            "This 26m deep well was rediscovered in 2003. Chiseled out of the\n" +
            "granite, it dates from the construction of the castle in the year 1225.\n" +
            "The well-house has been reconstructed according to a votive painting\n" +
            "dating from 1499.";

    public final String ALTE_INNBRUECKE_d = "Laut Chronist Lamprecht stammen die elf Pfeiler aus dem Jahre 1310;\n" +
            "sie wurden damals auf Granitfelsen im Flussbett errichtet. Beim Katastrophenhochwasser\n" +
            "1899 wurde die gesamte Holzfahrbahn\n" +
            "weggerissen.\n" +
            "Nach dem 2. Weltkrieg erhielt die 250 m lange Brücke eine\n" +
            "Eisenbetonkonstruktion.\n";
    public final String ALTE_INNBRUECKE_e =
            "According to the historian, Lamprecht, the eleven-pier bridge dating\n" +
            "from 1310 was erected on granite rocks on the bed of the river. However\n" +
            "it was in 1899 that catastrophically high floodwaters swept the\n" +
            "whole of the wooden decking away. After the Second World War, the\n" +
            "250m long bridge was rebuilt in reinforced concrete.";

    public final String KRIEGS_MAHNMAL_d = "1958 von Prof. Walter Ritter (Linz) geschaffen. Stellt die Schrecken des\n" +
            "Krieges in der Gestalt eines der apokalyptischen Reiter aus der Geheimen\n" +
            "Offenbarung des Johannes dar.\n";
    public final String KRIEGS_MAHNMAL_e =
            "Created by Prof. Walter Ritter of Linz in 1958, this war memorial uses\n" +
            "one of the Riders of the Apocalypse from the Revelation of St. John to\n" +
            "symbolize the horrors of war.";

    public final String KURHAUS_d = "Es steht auf einem kleinen Hügel im Eichbüchl.\n" +
            "1635 - 1638 entstand hier ein Kapuzinerkloster mit Kirche. Um 1800\n" +
            "Aufhebung des Klosters; 1814 wurde das Gebäude zum Amtshaus\n" +
            "umgebaut und 1928 durch den Konvent der Barmherzigen Brüder angekauft,\n" +
            "der an dessen Stelle die Kuranstalt errichtete. Die ehemalige\n" +
            "Kapuzinerkirche wurde zur Kurhauskirche umgestaltet. Das Bild an\n" +
            "der Langhauswand zeigt im unteren Teil einen Ausschnitt der Stadt mit\n" +
            "ausgebrannter Burg, dem Brückentor, einem Teil der Brücke und dem\n" +
            "Eichbüchl mit Sebastianskirche, Kapuzinerkloster und Stadtmauer,\n" +
            "gemalt\n" +
            "1738 von Michelangelo Unterberger. Die lebensgroßen barocken\n" +
            "Heiligenstatuen stammen aus der Wiener Rochuskirche.\n";

    public final String KURHAUS_e =
            "Schärding‘s Kneipp Health Resort, which was originally a Cistercian\n" +
            "Monastery built in 1635-1638, is situated on a small hill in the Eichbüchl.\n" +
            "Following the dissolution of the monastery around 1800, the\n" +
            "building was converted into government offices, but in 1928 was\n" +
            "purchased by the Order of Merciful Brothers, who used the site to erect\n" +
            "today‘s Kurhaus and henceforth used the old Cistercian church as the\n" +
            "Kurhaus church.";

    public final String BAROCKGARTEN_ORANGERIE_d = "Bevor Sie zur Station 26 weitergehen, machen Sie einen kurzen Abstecher\n" +
            "ins Eichbüchl und werfen einen Blick auf den Barockgarten\n" +
            "Orangerie. An der alten Stadtmauer wurde 1884 von Georg Wieninger\n" +
            "ein Gewächshaus mit Gärtnerwohnung liebevoll errichtet, das 2004\n" +
            "revitalisiert wurde und heute ein Restaurant – inmitten einer herrlichen\n" +
            "Parkanlage – beherbergt.\n";

    public final String BAROCKGARTEN_ORANGERIE_e =
            "Along the old town wall, Georg Wieninger built a greenhouse with\n" +
            "lovely decorated apartments for the gardeners that was renovated in\n" +
            "2004 and is now a restaurant surrounded by a wonderful\n" +
            "park. Before\n" +
            "you continue to station 26, make a short stop at Eichbüchl and have a\n" +
            "look at the Baroque garden Orangerie.";

    public final String EVANGELISCHE_KIRCHE_d = "Sebastianskirche oder Kirche am Stein (steht auf einem Granitfelsen),\n" +
            "erbaut zu Ehren der Pest- und Seuchenheiligen Sebastian und Rochus\n" +
            "zur Abwendung der Seuche um 1630. 1783 profaniert, später Theater\n" +
            "und Lagerraum. Nach sorgfältiger Restaurierung seit 1954 evangelische\n" +
            "Pfarrkirche.\n";

    public final String EVANGELISCHE_KIRCHE_e =
            "The Church of St. Sebastian, also known as the Church on the Rock\n" +
            "(situated on a solid block of granite) was originally built in 1630 in\n" +
            "honour of both St. Sebastian und St. Rochus. These are the saints of\n" +
            "all those afflicted by disease. This dedication was made in hope of\n" +
            "averting the fast - approaching plague. After deconsecreation in 1738\n" +
            "it was used as a theatre and warehouse. It was eventually restored and\n" +
            "reconsecrated as a Protestant parish Church in 1954.";

    public final String BEZIRKSHAUPTMANNSCHAFT_d = "1695 in dieser Grundform als Wohnhaus des Großhändlers Andreas\n" +
            "Schacky erbaut, nach 1782 Kastenamt, 1816 K.K. Land- und Pflegegericht\n" +
            "und seit 1854 Bezirksamt bzw. Bezirkshauptmannschaft.\n" +
            "Die heutige klassizistische Gestalt erhielt das Gebäude nach Bränden\n" +
            "von 1779 und 1809.\n";
    public final String BEZIRKSHAUPTMANNSCHAFT_e =
            "Built in 1695 as a private residence for the merchant, Andreas Schacky,\n" +
            "this building has long since served as government offices. It began its\n" +
            "official career as a land registry in 1782, but was later recast as an Austro-\n" +
            "Hungarian court for land disputes and did not become the district\n" +
            "commissioner‘s office it still is today until 1854. The Classical façade\n" +
            "was added after the fires of 1779 and 1809.";

    public final String SEILERGRABEN_d = "Die Türme entlang des Grabens deuten auf das ehemalige befestigte\n" +
            "Aussehen hin. Die Mauer selbst war höher und mit Zinnen versehen.\n" +
            "Die Rückfronten der Häuser der Silberzeile tragen hier einfache Spitzgiebeln.\n";
    public final String SEILERGRABEN_e =
            "The towers along the moat are reminders of its original purpose as part\n" +
            "of the town‘s defences. The wall used to have ramparts and was of\n" +
            "course much higher than it is now. The gables visible here are the rear\n" +
            "gables of the picturesque houses along the Silberzeile.";
}
