## 参考サイト
https://iikanji.hatenablog.jp/entry/2018/05/21/220844
https://github.com/LogNet/grpc-spring-boot-starter
## protoファイルからJavaクラス自動生成
```
./gradlew generateProto
```
## 動作確認
サーバー起動
```
./gradlew build
java -jar build/libs/grpc-0.0.1-SNAPSHOT.jar
または、
./gradlew bootRun
```
リクエスト
``` shell
curl localhost:8080/grpc/hoge
Hello hoge
```
## Docker イメージ化
ビルド
```shell
./gradlew build
## docker build [ -t ｛イメージ名｝ [ :｛タグ名｝ ] ] ｛Dockerfileのあるディレクトリ｝
docker build -t yuyalive/grpcjava:1.0 .
```
コンテナ起動
```shell
## docker run -p {ローカルポート}:{コンテナポート} {dockerイメージタグ}
docker run -p 9090:8080 -p 6565:6565  yuyh/grpcjava:1.0
```
リクエスト
``` shell
curl localhost:9090/grpc/hoge
Hello hoge
```

## k8s
デプロイ
```shell
kubectl apply -f grpc.yaml
```
ポートフォワード
```shell
kubectl port-forward svc/grpcjava 9000:8080
```
動作確認
```shell
ブラウザで以下アクセス
http://localhost:9000/grpc/test
```
