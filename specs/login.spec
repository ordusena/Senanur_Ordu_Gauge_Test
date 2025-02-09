Tüm Senaryolar
==========================

1. Kullanıcı başarılı bir şekilde login olur
----------
Tags:Basarili_Login
* "https://catchylabs-webclient.testinium.com/signIn" adresine gidilir
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol

2. Kullanıcı başarısız login olur
----------
Tags:Basarisiz_login
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu" ve "Kasavan97." değerini yazarak login ol
* "Username or Password Invalid!" yazısının ekranında göründüğü doğrulanır

3.Başarılı girişten sonra çıkış yapılır
----------
Tags:Log_out_olma
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Sistemden çıkış yap

4.Başarılı şekilde saving hesap oluştur
----------
Tags: Create_account_saving
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Saving Account oluştur

5.Account oluştururken hesap ismine sadece numara gir
----------
Tags: Create_account_checking_error
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Account ismi sadece sayı gir

6. Başarılı checking account oluştur
----------
Tags: Create_account_checking_error
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Checking Account oluştur

7. Edit account ile hesap ismi değiştirilir
----------
Tags: Edit_account_name
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Hesap ismi "SenaChecking" ile değiştir

8. Edit account sadece sayı hesap ismi ile değiştir
----------
Tags: Edit_account_name
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Hesap ismi sayi "123456" ile değiştir

8. Edit account boş hesap ismi ile değiştir
----------
Tags: Edit_account_name_empty
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Hesap ismini boş bırak

9. Transfer Money sayfasına başarılı gidilir
----------
Tags: Transfer_money_page
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Transfer Money sayfasına gidilir

9. Pozitif para gönderimi yapılır(Testinium-1)
----------
Tags: send_money_test1
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Para "200" girilerek gönderilir

10. Pozitif para gönderimi yapılır(Testinium-2)
----------
Tags: send_money_test2
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Para "Testinium-2" seçilerek "100" gönderilir

11. Pozitif para gönderimi yapılır(Testinium-3)
----------
Tags: send_money_test3
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Para "Testinium-3" seçilerek "100" gönderilir

12. Pozitif para gönderimi yapılır(Testinium-4)
----------
Tags: send_money_test4
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Para "Testinium-4" seçilerek "100" gönderilir

13. Pozitif para gönderimi yapılır(Testinium-5)
----------
Tags: send_money_test5
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Para "Testinium-5" seçilerek "100" gönderilir

14. Negatif para gönderimi yapılır(Testinium-1)
----------
Tags: neg_send_money_test1
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Para negatif "-200" girilerek gönderilir

15. Add Money sayfasına başarılı gidilir
----------
Tags: add_money_page
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Add Money sayfasına gidilir

16. Add Money başarılıyla gerçekleşir
----------
Tags: add_money
* "https://catchylabs-webclient.testinium.com/signIn" adresine gider
* Kullanıcı adı kısmına "senanur.ordu@testinium.com" ve "Kasavan97." değerini yazarak login ol
* Uygulama ana ekranına gidilir
* Para ekleme tüm bilgiler girerek yollanır