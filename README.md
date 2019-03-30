# Wolf for busy

[![CircleCI](https://circleci.com/gh/h-orito/wolf4busy-api/tree/develop.svg?style=svg)](https://circleci.com/gh/h-orito/wolf4busy-api/tree/develop)

## Overview

- 忙しい人のためのオプションルールを盛り込んだ人狼がプレイできるサイトです
- Kotlin で REST API を提供します
- 画面側は[wolf4busy-ui](https://github.com/h-orito/wolf4busy-ui)を参照

## Requirement for local development

- mysql

  - docker を使うなりインストールするなりして用意してください
  - ポートは 3306 を使用します

- maven
  - インストールしておいてください
  - いくつ以上なら大丈夫かわかりませんが私は`3.5`を使っています

## Setup for local development

- clone

  - 好きな場所にこのプロジェクトを clone してください
  - IntelliJ なり Eclipse なり好きな IDE で開いてください
  - maven プロジェクトとしてインポートすると良いでしょう
  - インポートしたら依存ライブラリを取り込んでおいてください

* DB

  - スキーマ、ユーザ情報は`application.yml`参照
  - 以下実行するとローカル開発用 DB がセットアップされます

  ```bash
  cd dbflute_xxxdb
  sh manage.sh 0
  ```

* 起動

  - `Wolf4busyApplication#main` を実行
  - http://localhost:8086/wolf4busy/ がベース URL になります

## Contribution

- こんな感じでお願いします

```
1. Fork it
2. Create a feature branch from develop ( e.g. feature/my-new-feature )
3. Implement your changes
4. Run JUnit test (please implement) and confirm that it passes
5. Commit your changes
6. Rebase your local changes against the develop branch
7. Create new Pull Request
```

- ブランチ名は`feature/{変更内容}`でお願いします。
  - Issue と紐づく場合は`#{Issue番号}`を含めてください。 e.g. `feature/valid_password#1`

## License

- MIT License

## Author

[h-orito](https://github.com/h-orito)

## Other

- API を提供しますが、後方互換性は特別な場合を除いて保つつもりはありません
