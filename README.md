# Senanur_Ordu_CatchyLabs_Test

Bu proje, bir para transferi uygulamasının test süreçlerini otomasyon ile doğrulamak amacıyla tasarlanmıştır. Proje, **Gauge** BDD çerçevesini kullanarak oluşturulmuş olup, Selenium tabanlı tarayıcı otomasyonu ve JSON dosyaları ile dinamik yapılandırma özelliklerine sahiptir.

## Proje Yapısı

### Dizinler ve Dosyalar
- **specs**:
    - `login.spec` ve `login.cpt`: Login sayfası ile ilgili Gauge test spesifikasyonları.
- **src/test**:
    - **java/driver**: WebDriver yönetimi ve tarayıcı oluşturulması.
        - `Driver.java`: WebDriver için genel yapılandırma.
        - `DriverFactory.java`: Farklı tarayıcılar için WebDriver oluşturma.
    - **java/org.example**:
        - `StepImplementation.java`: Test adımlarının Gauge'a bağlanması.
    - **java/utils**:
        - `LocatorReader.java`: JSON dosyalarından element bilgilerini okuma.
        - `Methods.java`: Test adımlarında kullanılan yardımcı metotlar.
    - **resources/locators**: Test sırasında kullanılan sayfa elementlerinin JSON formatında tanımlandığı dizin.
        - `loginpage.json`, `accountPage.json`: İlgili sayfalara ait locator bilgileri.
    - **resources**:
        - `config.properties`: Test yapılandırma bilgileri (örn. URL, tarayıcı seçimi).
        - `log4j.properties` ve `logback.xml`: Loglama yapılandırma dosyaları.

### Teknolojiler ve Kütüphaneler
- **Gauge**: Test spesifikasyonlarını oluşturmak için BDD framework.
- **Selenium 4**: Tarayıcı otomasyonu.
- **WebDriverManager**: WebDriver yönetimi.
- **Gson**: JSON işlemleri.
- **Maven**: Proje yapılandırması ve bağımlılık yönetimi.

## Kurulum

### Gereksinimler
- Java 11 veya üstü
- Maven 3.6 veya üstü
- IntelliJ IDEA (veya başka bir IDE)
- Chrome ve Firefox tarayıcıları (testler için)

### Adımlar
1. Projeyi klonlayın:
   ```bash
   git clone <REPO_URL>
   cd Senanur_Ordu_CatchyLabs_Test
   ```
2. Maven bağımlılıklarını yükleyin:
   ```bash
   mvn clean install
   ```
3. Test yapılandırmasını güncelleyin:
    - **resources/config.properties** dosyasını açın ve URL ile tarayıcı ayarlarını yapın:
      ```properties
      browser=chrome
      ```

## Kullanım

### Testleri Çalıştırma
1. **Tüm testleri çalıştırmak için**:
   ```bash
   mvn test
   ```
2. **Etiketli testleri çalıştırmak için** (örneğin, login senaryosu için):
   ```bash
   gauge run specs/ --tags "Tüm Senaryolar"
   ```


## Test Detayları

### Otomatik Test Senaryoları
1. **Login Fonksiyonu**:
    - Geçerli kullanıcı bilgileriyle başarılı giriş.
    - Hatalı bilgilerle giriş denemesi ve hata mesajlarının doğrulanması.

2. **Hesap Oluşturma**:
    - Yeni bir saving account oluşturma.
    - Boş bırakılan alanlarla işlem yapıldığında verilen uyarı mesajları.

3. **Para Transferi**:
    - Hesaplar arası başarılı para transferi.
    - Yetersiz bakiye durumlarında hata mesajlarının doğrulanması.


## Sorun Giderme
- **Driver sorunları**: Tarayıcı sürücünüz güncel değilse, `WebDriverManager` bağımlılıklarını güncelleyin.
- **Test başarısızlıkları**: `logs` klasöründe bulunan log dosyalarını kontrol edin.





