# 구현목표

### 본 프로젝트는 Solitare Card Game 중 Blackhole Game을 만드는 것이 목표이다. 주어진 카드를 모두 Blackhole에 연결하면 승리, 더 이상 BlackHole에 카드를 연결하지 못하면 패배한다.

# 구현 기능

* 키보드 입력을 통해 직접 카드를 Blackhole에 넣는 기능

# Reference
[1] Java Scanner 
https://docs.oracle.com/javase%2F8%2Fdocs%2Fapi%2F%2F/java/util/Scanner.html

[2] Java Random
https://docs.oracle.com/javase/8/docs/api/java/util/Random.html

[3] Game Rule
https://namu.wiki/w/%EB%B8%94%EB%9E%99%ED%99%80(%EA%B2%8C%EC%9E%84)

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

3. Java IDE(Eclipse)를 설치한다.
4. Eclipse에서 Blackhole.java를 실행한다.
```
1. https://www.eclipse.org/downloads/download.php?file=/oomph/epp/2022-12/R/eclipse-inst-jre-win64.exe 에서 Eclipse IDE 설치

2. (In Eclipse) Window -> Perspective -> Open Perspective -> Other... -> Git -> open
- Clone a Git repository -> URl: https://github.com/JSjiha/oss_pa2, Authentication: Your Username and Password -> next -> 로컬 저장소 지정
- Git repositories에서 우클릭 -> Import Projects -> Finish

3. ctrl + F11로 Blackhole.java 실행
```

### Linux

1. Java를 설치한다.(openjdk)
2. 환경 변수를 설정한다.
```
1. openjdk 설치
	sudo apt update
	sudo apt upgrade
	sudo apt install openjdk-11-jdk

- java 버전 확인
	java --version

2. 환경변수 설정
	sudo vim /etc/profile
	
- /etc/profile 파일 하단에 아래 내용 입력
	export JAVA_HOME=/usr/lib/jvm/java-11-openjdk-amd64 # 본인의 Java 설치경로
	export PATH=$JAVA_HOME/bin:$PATH
	export CLASSPATH=$CLASSPATH:$JAVA_HOME/lib/ext:$JAVA_HOME/lib/tools.jar

- 환경변수 확인 
	source /etc/profile
	echo $JAVA_HOME
```

3. terminal창에서 Blackhole.java를 실행한다.
```
1. Github에서 project clone
	git clone https://github.com/JSjiha/oss_pa2.git

2. Blackhole.java 컴파일 후 실행
	javac Blackhole.java
	java Blackhole
```

### MacOS

# 실행 예시
[게임 시작 화면]

![Blackhole -시작](https://github.com/JSjiha/oss_pa2/assets/164160018/f07ed52c-1c9d-45c1-b229-9dd42bf1aff5)






[Blackhole에 연결할 카드가 없어서 지는 상황]

![Blackhole -지는 경우](https://github.com/JSjiha/oss_pa2/assets/164160018/24d9099a-7a8d-4a0d-bacd-d091af3ea341)


# 코드 설명
## class Card
 - Description: 카드의 정보를 가지고 있다.
	value: A, 2, 3, ... , J, Q, K
	suit: c(clover), h(heart) s(spade) d(diamond)

## class Deck
 - Description: 카드 52개를 저장한다.
	1. public void shuffle(int seed): seed값을 받아 랜덤으로 댁을 섞는다.
	2. public Card dealCard(): 카드를 한장씩 나눠준다.

## class NotBlackholeCards
 - Description: 블랙홀이 아닌 카드들의 집합이다.

## class BlackholeAndCards
 - Description: 블랙홀 카드와 그 뒤로 연결될 공간을 만든다.

## main
 - 입력한 숫자(1~17)에 대하여 해당 더미의 Top에 있는 카드가 블랙홀과 연결될 수 있는지를 확인한다.
 - 연결할 수 있는 어떤 경우의 수도 없다면 게임을 패배한다.
 - 모든 카드가 연결되면 게임을 승리한다.

# TODO List
* 점수 계산하기
* GUI 구현하기
