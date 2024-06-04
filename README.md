# 구현목표

### 본 프로젝트는 Solitare Card Game 중 Blackhole Game을 만드는 것이 목표이다. 주어진 카드를 모두 Blackhole에 연결하면 승리, 더 이상 BlackHole에 카드를 연결하지 못하면 패배한다.

# 구현 기능

* 키보드 입력을 통해 직접 카드를 Blackhole에 넣는 기능

# Reference
[1] Java Scanner 
https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/java/util/Scanner.html

[2] Java Random
https://docs.oracle.com/javase/8/docs/api/java/util/Random.html

# 지원 Operating Systems 및 실행 방법

## 지원 Operating Systems
|OS| 지원 여부 |
|-----|--------|
|windows | :o:  |
| Linux  | :o: |
|MacOS  | :x:  |

## 실행 방법
### Windows

1. Java를 설치한다.
2. 환경변수를 설정한다.
```
1. https://www.oracle.com/java/technologies/downloads/#java17 에서 x64 Installer 다운로드

2. Window + R로 실행창을 열고, 실행창에 sysdm.cpl을 입력 후 enter

- 고급 -> 환경변수 -> 시스템 변수 [새로 만들기] ->  변수 이름: JAVA_HOME, 변수 값: java 설치 경로

- 시스템 변수 생성(이름: CLASSPATH) -> 시스템 변수 [편집] -> 새로 만들기 -> %JAVA_HOME%\bin 추가
```

3. Java IDE(Eclipse) 설치
4. Eclipse에서 Blackhole.java 실행
```
1. https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2022-12/R/eclipse-inst-jre-win64.exe 에서 Eclipse IDE 설치
2. (In Eclipse) Window -> Perspective -> Open Perspective -> Other... -> Git -> open
- Clone a Git repository -> URl: https://github.com/JSjiha/oss_pa2, Authentication: Your Username and Password -> next -> 로컬 저장소 지정
- Git repositories에서 우클릭 -> Import Projects -> Finish
3. ctrl + F11로 Blackhole.java 실행
```


### Linux

### MacOS

# 실행 예시

# 코드 설명

# TODO List
* 점수 계산하기
* GUI 구현하기
