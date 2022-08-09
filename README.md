# kotlin-server-handson

Kotlinサーバーサイドプログラミング実践開発のハンズオンをやったリポジトリ。  
公式のリポジトリは[こちら](https://github.com/n-takehata/kotlin-server-side-programming-practice)

Zennのスクラップは[こちら](https://zenn.dev/okaponta/scraps/578a2e0d0ea343)

# 動作バージョンなど

- macOS BigSur
- Apple M1 
- SpringBoot 2.7.2
- Ktor 2.0.3

# コードサンプルから大きめな変更点

## MyBatisGenerator

`com.arenagod.gradle.MybatisGeneratorTask`がGradle7系だと動かないので、  
`com.thinkimi.gradle.MybatisGenerator`を代わりに使用。

生成されるクラス名称や書き方をそれに伴い変更しています。

## フロントのchromedriverのバージョン

`package.json`を書き換えてchromedriverの89以降をいれないと、M1だと動かない。

## フロントからの通信時にCORSエラーが出て繋げない

`@CrossOrigin`のオプションに以下を付与  
`(origins = ["http://localhost:8081"], allowCredentials = "true")`

## SpringSecurityのバージョンが古いので、書き直し

例によって`WebSecurityConfigurerAdapter`がdeprecatedになったので、書き直してます。

## Ktorのバージョン違いによる文法違い

Ktorの1系と2系で書き方やライブラリの名称大きく変わるので、それに伴い変更。
