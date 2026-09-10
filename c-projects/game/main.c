#include <stdio.h>
#include <stdlib.h>

int main()
{
    int hrac[11];
    int c, a, b, d, q, z, s, w, g, p;
    printf("Ahoj. Ako sa volas? Meno:  ");
    scanf("%s", hrac);
    printf("%s, chces sa hrat moju hru? (a/n)\n", hrac);

    do{
        fflush(stdin);
        c = getch();
    } while(c != 'a' && c != 'n');
    if(c == 'a'){
        do{
            printf("Ste student na prazdninach v malom provincnom meste.\n V meste sa rozpravaju chyry o starom opustenom dome, do ktoreho sa miestni obyvatelia boja chodit.\n Dnes vecer sa rozhodnete vyskusat svoju odvahu a ist tam.");
            printf("Stojite pred opustenym domom. Steny sa olupuju, okna su rozbite a vo vzduchu visi pocit niecoho zlovestneho. Zostavaju vam tri zivoty. Co budete robit?\n 1. Vstupte do domu. \n 2. Odidte.\n");
            fflush(stdin);
            a = getch();
        }while(a != '1' && a != '2');
        if(a == '1'){
            do {
                printf("Rozhodnete sa ist dovnutra. Len co prekrocite prah, dvere sa za vami s hlasnym buchnutim zatvoria. Mate pocit, akoby vas dom sledoval.\n Na poschodi je schodisko a tmava chodba do suterenu. Ktorym smerom pojdes?\n 1. Vyjdite na prve poschodie.\n 2. Prejdite do suterenu.\n");
               fflush(stdin);
                b = getch();
            }while(b != '1' && b != '2');
            if(b == '1'){
                do{
                    printf("Vystupite po starom vrzgajucom schodisku. Na prvom poschodi je dlha chodba s niekolkymi dverami. Jedny dvere su pootvorene a pocujes spoza nich slaby sepot.\n 1. Prejdite cez pootvorene dvere.\n 2. Otvorte dalsie dvere.\n");
                    fflush(stdin);
                    d = getch();
                }while(d != '1' && d != '2');
                if(d == '1'){
                    do{
                        printf("Vojdete do miestnosti a v tmavom rohu uvidite postavu. Sepot je coraz hlasnejsi a zrazu sa na teba vrhne tien. Ste v šoku. Vratite sa na chodbu na 1. poschodi.\n");
                        printf("Vyjdete z miestnosti a pocujete, ako za vami nieco vrzga. Akoby sa vas dom snazil chytit. Rozhodnite sa utiect!\n 1. Utek z domova.\n 2. Pokusit sa skryt.\n");
                        fflush(stdin);
                        q = getch();
                    }while(q != '1' && q != '2');
                    if(q == '1'){
                        printf("Vybehnes z domu a dvere sa za tebou s hlasnym buchnutim zabuchnu. Ulavi sa vam a uvedomite si, ze ste prezili.\n Gratulujeme, to je vyhra!");
                    }else{
                        printf("Najdes si odlahle miesto a snazis sa utiahnut, ale dom ta nepusti. Citis, ako ta nieco pokryva tmou.....\n Stratili ste(((.");
                    }
                }else{
                    do{
                        printf("Otvorite jedny zo zamknutych dveri. Vnutri je stara detska izba, zaprasena, ale bez znamok nebezpecenstva. Rozhodnes sa urobit si malu prestavku. Vratil si sa na chodbu.\n");
                        printf("Vyjdete z miestnosti a pocujete, ako za vami nieco vrzga. Akoby sa vas dom snazil chytit. Rozhodnite sa utiect!\n 1. Utek z domova.\n 2. Pokusit sa skryt.\n");
                        fflush(stdin);
                        q = getch();
                    }while(q != '1' && q != '2');
                    if(q == '1'){
                        printf("Vybehnes z domu a dvere sa za tebou s hlasnym buchnutim zabuchnu. Ulavi sa vam a uvedomite si, ze ste prezili.\n Gratulujeme, to je vyhra!");
                    }else{
                        printf("Najdes si odlahle miesto a snazis sa utiahnut, ale dom ta nepusti. Citis, ako ta nieco pokryva tmou.....\n Stratili ste(((.");
                    }
                }
            }else{
                do{
                    printf("Zostupis do vlhkej pivnice. Pachne zatuchlinou a z tmy sa ozyva zvlastny skripavy zvuk. V rohu uvidite staru truhlicu a velku skrinu.\n 1. Pristup k hrudniku.\n 2. Otvorte skrinu.\n");
                    fflush(stdin);
                    z = getch();
                }while(z != '1' && z != '2');
                if(z == '1'){

                    do {

                        printf("Opatrne sa priblizite k starej truhlici. Ked sa dotknes veka, nieco ta zvnutra chyti za ruku!\n 1. Skuste truhlicu znovu otvorit.\n 2. Vyjdite z pivnice.\n");
                        fflush(stdin);
                        s = getch();
                    }while(s != '1' && s != '2');
                    if(s == '1'){
                        printf("Rozhodnete sa nevzdavat a znova zdvihnete veko truhlice. Tentoraz sa zvnutra vyplazi tmava hmla a zacne ti obklopovat ruky. Truhlica zacne vibrovat a zrazu pocitis silny stisk v hrudi.");
                        printf("Prichadzate o posledny zvysok svojho zivota. Pohlti ta temnota a ty padas na zem, uvedomujuc si, ze toto je tvoj koniec.\n Stratili ste(((.");
                    }else{
                        printf("Stupate po schodoch, ale zrazu zakopnete a spadnete. Cele telo vam zaplavi chlad a vy si uvedomite, ze uz nemate silu. Vas posledny zivot je prec.\n Stratili ste(((.");
                    }
                }else{
                    do{
                        printf("Opatrne prejdes k starej skrini a otvoris jej vrzgajuce dvere. Vnutri su police pokryte prachom. Na jednej z polic si vsimnes zvlastnu staru babiku s prazdnymi ocami, ktora posobi strasidelne realisticky.\n");
                        printf("Ked sa babiky dotknete, jej oci zacnu ziarit. Zrazu citite, ako vas nieco zacne tahat dovnutra skrine, akoby to bolo zive. Snazite sa vyslobodit, ale skrina vas stale vtahuje dovnutra.\n 1. Pustite babiku a utekajte.\n 2. Snaha dostat babiku von a preskumat ju dalej.\n");
                        fflush(stdin);
                        w = getch();
                    }while(w != '1' && w != '2');
                    if(w == '1'){
                        do{
                            printf("Pustis babiku, vstanes a vratis sa na chodbu.\n");
                            printf("Pocujete, ako za vami nieco vrzga. Akoby sa vas dom snazil chytit. Rozhodnite sa utiect!\n 1. Utek z domova.\n 2. Pokusit sa skryt.\n");
                            fflush(stdin);
                            q = getch();
                       }while(q != '1' && q != '2');
                        if(q == '1'){
                            printf("Vybehnes z domu a dvere sa za tebou s hlasnym buchnutim zabuchnu. Ulavi sa vam a uvedomite si, ze ste prezili.\n Gratulujeme, to je vyhra!");
                        }else{
                            printf("Najdes si odlahle miesto a snazis sa utiahnut, ale dom ta nepusti. Citis, ako ta nieco pokryva tmou.....\n Stratili ste(((.");
                        }

                    }else{
                        printf("Napriek strachu sa rozhodnete babiku nepustit. Ked ju vytiahnes, skrina sa zrazu s hlasnym prasknutim zavrie a ty spadnes na zem. Babika zacne nieco sepkat v nezrozumitelnom jazyku. Obklopi vas zvlastna energia a vy citite, ako stracate silu.\n Tvoje vedomie zahali tma a svet okolo teba zmizne....\n Stratili ste(((.\n");
                    }
                }
            }
        }else{
            do{
                printf("Rozhodnete sa, ze je lepsie nepokusat stastie, a otocite sa spat. Ale prave ked urobite niekolko krokov spat, vonku sa ozve zvlastny sepot a pred vami sa objavi tien.\n 1. Spat do domu.\n 2. Pokusit sa uniknut dalej.\n");
                fflush(stdin);
                g = getch();
            }while(g != '1' && g != '2');
            if(g == '1'){
                do{
                    printf("Stojite pred opustenym domom. Steny sa olupuju, okna su rozbite a vo vzduchu visi pocit niecoho zlovestneho. Co budete robit?\n 1. Vstupte do domu. \n 2. Odidte.\n");
                    fflush(stdin);
                    a = getch();
                }while(a != '1' && a != '2');
                if(a == '1'){
                    do{
                        printf("Rozhodnete sa ist dovnutra. Len co prekrocite prah, dvere sa za vami s hlasnym buchnutim zatvoria. Mate pocit, akoby vas dom sledoval.\n Na poschodi je schodisko a tmava chodba do suterenu. Ktorym smerom pojdes?\n 1. Vyjdite na prve poschodie.\n 2. Prejdite do suterenu.\n");
                        fflush(stdin);
                        b = getch();
                    }while(b != '1' && b != '2');
                    if(b == '1'){
                        do{
                            printf("Vystupite po starom vrzgajucom schodisku. Na prvom poschodi je dlha chodba s niekolkymi dverami. Jedny dvere su pootvorene a pocujes spoza nich slaby sepot.\n 1. Prejdite cez pootvorene dvere.\n 2. Otvorte dalsie dvere.\n");
                            fflush(stdin);
                            d = getch();
                        }while(d != '1' && d != '2');
                        if(d == '1'){
                            do{
                                printf("Vojdete do miestnosti a v tmavom rohu uvidíte postavu. Sepot je coraz hlasnejsi a zrazu sa na teba vrhne tien. Ste v šoku. Vratite sa na chodbu na 1. poschodi.\n");
                                printf("Vyjdete z miestnosti a pocujete, ako za vami nieco vrzga. Akoby sa vas dom snazil chytit. Rozhodnite sa utiect!\n 1. Utek z domova.\n 2. Pokusit sa skryt.\n");
                                fflush(stdin);
                                q = getch();
                            }while(q != '1' && q != '2');
                            if(q == '1'){
                                printf("Vybehnes z domu a dvere sa za tebou s hlasnym buchnutim zabuchnu. Ulavi sa vam a uvedomite si, ze ste prezili.\n Gratulujeme, to je vyhra!");
                            }else{
                                printf("Najdes si odlahle miesto a snazis sa utiahnut, ale dom ta nepusti. Citis, ako ta nieco pokryva tmou.....\n Stratili ste(((.");
                            }
                        }
                    }else{
                        do{
                        printf("Zostupis do vlhkej pivnice. Pachne zatuchlinou a z tmy sa ozyva zvlastny skripavy zvuk. V rohu uvidite staru truhlicu a velku skrinu.\n 1. Pristup k hrudniku.\n 2. Otvorte skrinu.\n");
                        fflush(stdin);
                        z = getch();
                        }while(z != '1' && z != '2');
                        if(z == '1'){
                            do {
                                printf("Opatrne sa priblizite k starej truhlici. Ked sa dotknes veka, nieco ta zvnutra chyti za ruku!\n 1. Skuste truhlicu znovu otvorit.\n 2. Vyjdite z pivnice.\n");
                                fflush(stdin);
                                s = getch();
                            }while(s != '1' && s != '2');
                            if(s == '1'){
                                printf("Rozhodnete sa nevzdavat a znova zdvihnete veko truhlice. Tentoraz sa zvnutra vyplazi tmava hmla a zacne ti obklopovat ruky. Truhlica zacne vibrovat a zrazu pocitis silny stisk v hrudi.");
                                printf("Prichadzate o posledny zvysok svojho zivota. Pohlti ta temnota a ty padas na zem, uvedomujuc si, ze toto je tvoj koniec. Stratili ste(((.");
                            }else{
                                printf("Stupate po schodoch, ale zrazu zakopnete a spadnete. Cele telo vam zaplavi chlad a vy si uvedomite, ze uz nemate silu.\n Stratili ste(((.");
                            }
                        }else{
                            do{
                                printf("Opatrne prejdes k starej skrini a otvoris jej vrzgajuce dvere. Vnutri su police pokryte prachom. Na jednej z polic si vsimnes zvlastnu staru babiku s prazdnymi ocami, ktora posobi strasidelne realisticky.\n");
                                printf("Ked sa babiky dotknete, jej oci zacnu ziarit. Zrazu citite, ako vas nieco zacne tahat dovnutra skrine, akoby to bolo zive. Snazite sa vyslobodit, ale skrina vas stale vtahuje dovnutra.\n 1. Pustite babiku a utekajte.\n 2. Snaha dostat babiku von a preskumat ju dalej.\n");
                                fflush(stdin);
                                w = getch();
                            }while(w != '1' && w != '2');
                            if(w == '1'){
                                do{
                                    printf("Pustis babiku, vstanes a vratis sa na chodbu.\n");
                                    printf("Pocujete, ako za vami nieco vrzga. Akoby sa vas dom snazil chytit. Rozhodnite sa utiect!\n 1. Utek z domova.\n 2. Pokusit sa skryt.\n");
                                    fflush(stdin);
                                    q = getch();
                                }while(q != '1' && q != '2');
                                if(q == '1'){
                                    printf("Vybehnes z domu a dvere sa za tebou s hlasnym buchnutim zabuchnu. Ulavi sa vam a uvedomite si, ze ste prezili.\n Gratulujeme, to je vyhra!");
                                }else{
                                    printf("Najdes si odlahle miesto a snazis sa utiahnut, ale dom ta nepusti. Citis, ako ta nieco pokryva tmou.....\n Stratili ste(((.");
                                }
                            }else{
                                printf("Napriek strachu sa rozhodnete babiku nepustit. Ked ju vytiahnes, skrina sa zrazu s hlasnym prasknutim zavrie a ty spadnes na zem. Babika zacne nieco sepkat v nezrozumitelnom jazyku. Obklopi vas zvlastna energia a vy citite, ako stracate silu. Stratíš svoj posledný život.\n Tvoje vedomie zahali tma a svet okolo teba zmizne....\n Stratili ste(((.\n");
                            }
                        }

                    }
                }
            }else{
                do{
                    printf("Zacnete utekat, ale tien vas prenasleduje. Kroky su coraz hlasnejsie a vam je zrazu velmi zima. Obzriete sa a vidite, ako sa po vas nieco nacahuje.\n 1. Skuste opat utiect.\n 2.  Spat do domu.\n");
                    fflush(stdin);
                    p = getch();
                }while(p != '1' && p != '2');
                if(p == '1'){
                    printf("Podarilo sa vam uniknut. Gratulujeme, to je vyhra!\n");
                }else{
                    do{
                    printf("Stojite pred opustenym domom. Steny sa olupuju, okna su rozbite a vo vzduchu visi pocit niecoho zlovestneho. Co budete robit?\n 1. Vstupte do domu. \n 2. Odidte.\n");
                    fflush(stdin);
                    a = getch();
                }while(a != '1' && a != '2');
                if(a == '1'){
                    do{
                        printf("Rozhodnete sa ist dovnutra. Len co prekrocite prah, dvere sa za vami s hlasnym buchnutim zatvoria.\n Na poschodi je schodisko a tmava chodba do suterenu. Ktorym smerom pojdes?\n 1. Vyjdite na prve poschodie.\n 2. Prejdite do suterenu.\n");
                        fflush(stdin);
                        b = getch();
                    }while(b != '1' && b != '2');
                    if(b == '1'){
                        do{
                            printf("Vystupite po starom vrzgajucom schodisku. Na prvom poschodi je dlha chodba s niekolkymi dverami. Jedny dvere su pootvorene a pocujes spoza nich slaby sepot.\n 1. Prejdite cez pootvorene dvere.\n 2. Otvorte dalsie dvere.\n");
                            fflush(stdin);
                            d = getch();
                        }while(d != '1' && d != '2');
                        if(d == '1'){
                            do{
                                printf("Vojdete do miestnosti a v tmavom rohu uvidíte postavu. Sepot je coraz hlasnejsi a zrazu sa na teba vrhne tien. Ste v šoku. Vratite sa na chodbu na 1. poschodi.\n");
                                printf("Vyjdete z miestnosti a pocujete, ako za vami nieco vrzga. Akoby sa vas dom snazil chytit. Rozhodnite sa utiect!\n 1. Utek z domova.\n 2. Pokusit sa skryt.\n");
                                fflush(stdin);
                                q = getch();
                            }while(q != '1' && q != '2');
                            if(q == '1'){
                                printf("Vybehnes z domu a dvere sa za tebou s hlasnym buchnutim zabuchnu. Ulavi sa vam a uvedomite si, ze ste prezili.\n Gratulujeme, to je vyhra!");
                            }else{
                                printf("Najdes si odlahle miesto a snazis sa utiahnut, ale dom ta nepusti. Citis, ako ta nieco pokryva tmou.....\n Stratili ste(((.");
                            }
                        }
                    }else{
                        do{
                            printf("Zostupis do vlhkej pivnice. Pachne zatuchlinou a z tmy sa ozyva zvlastny skripavy zvuk. V rohu uvidite staru truhlicu a velku skrinu.\n 1. Pristup k hrudniku.\n 2. Otvorte skrinu.\n");
                            fflush(stdin);
                            z = getch();
                        }while(z != '1' && z != '2');
                        if(z == '1'){
                            do {
                                printf("Opatrne sa priblizite k starej truhlici. Ked sa dotknes veka, nieco ta zvnutra chyti za ruku!\n 1. Skuste truhlicu znovu otvorit.\n 2. Vyjdite z pivnice.\n");
                                fflush(stdin);
                                s = getch();
                            }while(s != '1' && s != '2');
                            if(s == '1'){
                                printf("Rozhodnete sa nevzdavat a znova zdvihnete veko truhlice. Tentoraz sa zvnutra vyplazi tmava hmla a zacne ti obklopovat ruky. Truhlica zacne vibrovat a zrazu pocitis silny stisk v hrudi.");
                                printf("Prichadzate o posledny zvysok svojho zivota. Pohlti ta temnota a ty padas na zem, uvedomujuc si, ze toto je tvoj koniec. Stratili ste(((.");
                            }else{
                                printf("Stupate po schodoch, ale zrazu zakopnete a spadnete. Cele telo vam zaplavi chlad a vy si uvedomite, ze uz nemate silu. Vas posledny zivot je prec.\n Stratili ste(((.");
                            }
                        }else{
                            do{
                                printf("Opatrne prejdes k starej skrini a otvoris jej vrzgajuce dvere. Vnutri su police pokryte prachom. Na jednej z polic si vsimnes zvlastnu staru babiku s prazdnymi ocami, ktora posobi strasidelne realisticky.\n");
                                printf("Ked sa babiky dotknete, jej oci zacnu ziarit. Zrazu citite, ako vas nieco zacne tahat dovnutra skrine, akoby to bolo zive. Snazite sa vyslobodit, ale skrina vas stale vtahuje dovnutra.\n 1. Pustite babiku a utekajte.\n 2. Snaha dostat babiku von a preskumat ju dalej.\n");
                                fflush(stdin);
                                w = getch();
                            }while(w != '1' && w != '2');
                            if(w == '1'){
                                do{
                                    printf("Pustis babiku, vstanes a vratis sa na chodbu.\n");
                                    printf("Pocujete, ako za vami nieco vrzga. Akoby sa vas dom snazil chytit. Rozhodnite sa utiect!\n 1. Utek z domova.\n 2. Pokusit sa skryt.\n");
                                    fflush(stdin);
                                    q = getch();
                                }while(q != '1' && q != '2');
                                if(q == '1'){
                                    printf("Vybehnes z domu a dvere sa za tebou s hlasnym buchnutim zabuchnu. Ulavi sa vam a uvedomite si, ze ste prezili.\n Gratulujeme, to je vyhra!");
                                }else{
                                    printf("Najdes si odlahle miesto a snazis sa utiahnut, ale dom ta nepusti. Citis, ako ta nieco pokryva tmou.....\n Stratili ste(((.");
                                }
                            }else{
                                printf("Napriek strachu sa rozhodnete babiku nepustit. Ked ju vytiahnes, skrina sa zrazu s hlasnym prasknutim zavrie a ty spadnes na zem. Babika zacne nieco sepkat v nezrozumitelnom jazyku. Obklopi vas zvlastna energia a vy citite, ako stracate silu. Stratíš svoj posledný život.\n Tvoje vedomie zahali tma a svet okolo teba zmizne....\n Stratili ste(((.\n");
                            }
                        }

                    }
                }
                }
            }
        }

    }else{
        printf("oh, so bad ;-(");
    }
};
