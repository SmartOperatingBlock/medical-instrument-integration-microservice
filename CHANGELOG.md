## 1.0.0 (2023-02-11)


### Features

* create a controller for medical instrument ([099c975](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/099c975476a17d332a8e506b787de5faa33cff49))
* create json deserializer for telemetry data ([bbc1946](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/bbc1946436e1faca6de3a9da29f018365cc2d1ca))
* create jsonPatchSerializer ([b837378](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/b8373784c5633c63e851c615c998719422b9b549))
* create manager for medical instrument to pulish data on azure digital twin plaftorm ([dc546e5](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/dc546e58fd8856017835d905303a5eb6bb29e944))
* create receiver of medical instrument data ([742082b](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/742082b566cdac3fc8f159c23c74c22697c2297e))
* create telemetry system class ([62b59a8](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/62b59a82a7c5d2f858875eb73d5916046262cbfd))
* create telemetrydata class ([bfdc4e2](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/bfdc4e2603aed20a7523df928762c89d262cee8a))


### Bug Fixes

* correct expected string in serialization test ([2fdb4ee](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/2fdb4ee7e50eda1e0e8c1696ed56fd5c8dd86269))


### Refactoring

* change some variables name ([d65e519](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/d65e5193d616c3c6ef39fd810b457609b8b8958b))
* move deserializer in application.presenter package ([82a08a2](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/82a08a2447b565c4e0d5ff91a94cb3932e8d6bbc))


### General maintenance

* add azure dependencies ([878c215](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/878c215652c3a8fca186f71afa3d7d039cb213e6))
* add blood pressure data class ([c8d6857](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/c8d68570ae9d2a796bc50278544fd78ac5c4b75f))
* add data class for body temperature ([3a4aeb8](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/3a4aeb851821eb59d9fb39360d3af53c57744246))
* add enums for unit of measurement ([7eaa25b](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/7eaa25b21de9c47c97c37812a7d94f8d3418098d))
* add Gson dependency ([558fffe](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/558fffeb92e6659c5342d251b973fa75c3c53b1a))
* add heart beat data class ([3b0f699](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/3b0f69994fa22e01c72f7ee576c3904374fe1593))
* add respiration rate data class ([122fe5d](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/122fe5d37b07c55aa5385a22e5973ae9778f31cd))
* add saturation data class ([f6c0eea](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/f6c0eeabd7aea4b5a5f7aed274399dfcdab5d576))
* add simple simulation of data received from a third-party system about medical instrument ([9e0022f](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/9e0022f8fb23b7c15b67ab312a9b037042de00be))
* add test for telemetry data ([211d0ea](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/211d0ea6ba153d348da7f2e89254cb21c62cea65))
* add validation of percentage in saturation class ([a1cef0e](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/a1cef0ee618faa7ca1ef7e88b6a829f4ae33a583))
* change project name ([b051360](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/b051360c44412b5922a423a3278270bce996527b))
* create interface for a serializer ([48fa92f](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/48fa92f5e38bb12a5e0d04ee57e564aa913055f5))
* create interface for medical instrument managament ([611889f](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/611889f8ec13baed676cc5a33228fa3a03f4bdf3))
* create interface of a deserializer ([3dd67d4](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/3dd67d455c1c78c73123a83dcf6a597ec7c0d165))
* create object to manage jsonPatch path ([ea3900f](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/ea3900fd9f03c4aa278cc1b722b31eed93c149a7))
* create object with all key of a telemetry data json ([ff93575](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/ff93575aa95c00ae7ee9ac1cd9fee265c4467a25))
* delete sample test class ([97e77f0](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/97e77f0ca22b4c14ae59bb227ba8905b12fe413f))
* modify a comment ([ea20594](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/ea20594af68aa27e352309875da5bb744a4ce690))
* move medicalInstrumentID and PatientID to MedicalInstrument ([930d517](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/930d517f0ea9872f5695259d6138d84599897ea7))
* now telemetrySystemID and patientID are string instead int ([2fd628f](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/2fd628f3f3822f5c71b7a23cc331217601157f10))
* update readme ([9fa3cba](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/9fa3cbad63dd2110efbe5857dd35d2378f3a240a))


### Build and continuous integration

* edit workflow to publish doc in kdoc directory ([b318faf](https://github.com/SmartOperatingBlock/medical-instrument-integration-microservice/commit/b318fafac189b929263596f4cadaa35f393846c0))

## [0.1.1](https://github.com/SmartOperatingBlock/kotlin-template-project/compare/0.1.0...0.1.1) (2023-02-06)


### General maintenance

* activate publish on github pages by semantic release plugin ([8a9001c](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/8a9001cea81ea319a19af37f6545a0bc7a86a31d))
* add Dockerfile ([2a36c9f](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/2a36c9f6b542ffb6d59fe8b3a915f15b83dae755))
* add plugin for publish documentation to github pages ([99eb3c8](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/99eb3c8e3fd98388f268fc1443e6f8186e44606e))
* change plugin for publish documentation to github pages ([ced9b0a](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/ced9b0ab4d85184eb7cca15726c1e156e82bff7d))
* configure semantic release to deploy documentation on github pages ([683e53f](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/683e53f6383286a7ee51a2a4d9d5d6cac8221e2c))
* ensure ci success before merging pull request ([4c124f4](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/4c124f4ab5dc3533f343fb84c3261bdd82ebf8e3))
* update gitignore ([d1d1ba3](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/d1d1ba3a8d1ed41c8fdbc6e68a1fa48121bb8500))
* update gitignore with checkstyle-idea file ([5065596](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/506559626d185616be0b497f828b3954a6a7639c))
* update README ([f9800e0](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/f9800e04b39a1ae2826adbff26592f08fba534cd))


### Build and continuous integration

* add codecov action to generate coverage from jacoco report ([e0365aa](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/e0365aa1d2b767c1d773106f74f00489a461c544))
* add docker image auto delivery ([05f996d](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/05f996d993fd29f7dfb9f8f268d8d1cca365fab2))
* add docs generation step ([6073bda](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/6073bdaa781bf7679de69ffa711b7af8834b7f36))
* **deps:** update docker/build-push-action action to v3.3.1 ([a19985a](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/a19985a3d47ce45d4c1133527c89314eeb3257fe))
* **deps:** update docker/build-push-action action to v4 ([2f667d7](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/2f667d7835f9c55f6de1cc5f808de51d973b645d))
* export version number from semantic release ([922a212](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/922a2125cb81b830026737608e7d0bd04cab57bc))
* make image name lowercase ([3e34d6d](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/3e34d6d37b2ad7b682b0418ff2c2e6ed6f690327))
* modify condition for documentation deploy ([76fcef6](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/76fcef6b274f8489ce642c2d49c77ae2cd572a16))
* modify release concurrency group ([9002f26](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/9002f2625f0e6d1ad758b0ddb906c6c1af985a49))


### Dependency updates

* **core-deps:** update dependency org.jetbrains.kotlin:kotlin-stdlib to v1.8.10 ([d637f2e](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/d637f2ebc93c686311057c0790cb17a8db6af3e5))
* **deps:** update node.js to 18.14 ([e7105c5](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/e7105c5c6d3192852b8d79056385e94bf6937264))
* **deps:** update plugin com.gradle.enterprise to v3.12 ([ccce09d](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/ccce09d55f5b0a2ced1aefb6d0db386e47d1bc81))
* **deps:** update plugin com.gradle.enterprise to v3.12.1 ([bf28ba4](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/bf28ba43df7a82e7cbcb8e44d2fa874f533da2de))
* **deps:** update plugin com.gradle.enterprise to v3.12.2 ([5a11c72](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/5a11c72463d7d37f9f46070b429fa5973a5d4aa8))
* **deps:** update plugin com.gradle.enterprise to v3.12.3 ([18e6393](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/18e63935ef61344e5079600d0f8adaa1a6283b28))
* **deps:** update plugin kotlin-qa to v0.32.0 ([43155c8](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/43155c8a0fe2c07c3add9beeb42017822d2d0062))
* **deps:** update plugin kotlin-qa to v0.33.0 ([7e80e6f](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/7e80e6f763899189951763d01d3cfc6daa554bce))
* **deps:** update plugin org.danilopianini.gradle-pre-commit-git-hooks to v1.1.1 ([920e201](https://github.com/SmartOperatingBlock/kotlin-template-project/commit/920e201193df0f1cbe0a8c6f4104293ce0d99a3c))
