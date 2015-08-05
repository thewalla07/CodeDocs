##############################################source("projectCode.r", echo=T,max.deparse.length=10000)##########################

# Project by: (name -- student number)
#   Michael Wall -- 13522003
#   Gillian Morrison -- 13516913
#   Daire O'Bruachail -- 13479738
#   Kirill Sloka -- 13405888

# This project is completely our own work

#   source("projectCode.r", echo=T,max.deparse.length=10000)
# The above line runs the following code. 
# There are warnings as a result of some of the data, this we are aware of

install.packages("gtools")
library(gtools)

ir = read.csv("C:/CA266/Project/irish results.csv", header=T)
br = read.csv("C:/CA266/Project/british results.csv", header=T)

#========== methods used for calculating behind values and finishing times

#ir = read.csv("ir.csv", header=T)
#br = read.csv("br.csv", header=T)


conDht <- function(x){
	gsub("Dht", "0", x, fixed=T)
}

conShd <- function(x){
	gsub("shd", "0.1", x, fixed=T)
}

conHd <- function(x){
	gsub("hd", "0.2", x, fixed=T)
}

conNk <- function(x){
	gsub("nk", "0.3", x, fixed=T)
}

conNose <- function(x){
	gsub("nose", "0.05", x, fixed=T)
}

conL <- function(x){
	gsub("L", "", x, fixed=T)
}

conAll <- function(x){
	x<-conShd(x)
	x<-conHd(x)
	x<-conDht(x)
	x<-conNose(x)
	x<-conL(x)
	x
}

convertToFeet <- function(x){
	x<-conAll(x)
	x<-as.numeric(x)
	x*8
}

conDist <- function(x){
	x<-as.numeric(x)
	x<-x*5280
	x
}

expectedTime <- function(d, t, b){
	d<-conDist(d)
	d<-as.numeric(d)
	t<-as.numeric(t)
	suppressWarnings(b<-convertToFeet(b))
	t<-(d*t)/(d-b)
	t	
}

calcOdds <- function(a, f){
	(f/(a+f))*100
}

#================= Error checking in times ==============================

missingir <- is.na(ir$Time.in.secs)
summary(missingir)

missingbr <- is.na(br$Behind)
summary(missingbr)

#================= Calculate expected finish time per horse, NA if DNF =====================
br$Behind <- as.character(br$Behind)
br<-br[-nrow(br),]
br$Time.in.secs<-expectedTime(br$distance, br$Winner.Race.Time, br$Behind)
br$Time.in.secs[br$position==1]<-br$Winner.Race.Time[br$position==1]

#======================== Merging datasets ==============
ir$Breeder..irish.<-NULL
br$Do.not.use<-NULL
br<-cbind(br, Time.in.secs=0)
suppressWarnings(cr <- smartbind(br, ir))
summary(br)
summary(ir)
summary(cr)

#========== PercentageOdds per horse ===================
cr<- cbind(cr, PercentageOdds=0)
cr$PercentageOdds<-calcOdds(cr$Against, cr$For)

#========== Percentage Gross profit for Bookies ==================
totalOddsPerRace <- tapply(cr$PercentageOdds, cr$Date.time, sum)
totalOddsPerRace<-as.data.frame(totalOddsPerRace)
totalOddsPerRace<-cbind(Date=c(rownames(totalOddsPerRace)),totalOddsPerRace)
rownames(totalOddsPerRace)<-1:nrow(totalOddsPerRace)
names(totalOddsPerRace)[names(totalOddsPerRace)=="totalOddsPerRace"]<-"Total"
mean(totalOddsPerRace$Total)
summary(totalOddsPerRace$Total)

#=========== get dataset of all horses who came first
numTimesFirst<- tapply(cr$position==1, cr$horse, sum)
numTimesFirst<-as.data.frame(numTimesFirst)
numTimesFirst<-cbind(Horse=c(rownames(numTimesFirst)),numTimesFirst)
rownames(numTimesFirst)<-1:nrow(numTimesFirst)
names(numTimesFirst)[names(numTimesFirst)=="numTimesFirst"]<-"wins"
winners<-numTimesFirst

#=========== get subset of dataset, containing horses who won more than 8 times
topHorses<- winners[winners$wins>8,]
topHorses<-topHorses[2:nrow(topHorses),] #removes an odd NA from the first row

#=========== view these top horses
topHorses

#======================  **** NOTE **** ===================
# the following code is not automated, but as a result of manual analyses of the small data in topHorses
# therefor, if this code was applied to a different data set it would not work
# it is designed to show why these horses are the best to bet on

#=========== average percentage odds in a race
mean(cr[cr$horse=="Annie Power (IRE)",c("PercentageOdds")])
mean(cr[cr$horse=="Glens Melody (IRE)",c("PercentageOdds")])
mean(cr[cr$horse=="Hurricane Fly (IRE)",c("PercentageOdds")])
mean(cr[cr$horse=="Jezki (IRE)",c("PercentageOdds")])
mean(cr[cr$horse=="Rebel Fitz (FR)",c("PercentageOdds")])


#=========== average position in a race
mean(cr[cr$horse=="Annie Power (IRE)",c("position")])
mean(cr[cr$horse=="Glens Melody (IRE)",c("position")])
mean(cr[cr$horse=="Hurricane Fly (IRE)",c("position")])
mean(cr[cr$horse=="Jezki (IRE)",c("position")])
mean(cr[cr$horse=="Rebel Fitz (FR)",c("position")])

#========== Each horse gets their own dataset
t1<-cr[cr$horse=="Annie Power (IRE)",c("position")]
t2<-cr[cr$horse=="Glens Melody (IRE)",c("position")]
t3<-cr[cr$horse=="Hurricane Fly (IRE)",c("position")]
t4<-cr[cr$horse=="Jezki (IRE)",c("position")]
t5<-cr[cr$horse=="Rebel Fitz (FR)",c("position")]

#========== win/lose ratio of each horse
sum(t1==1)/sum(t1>1)
sum(t2==1)/sum(t2>1)
sum(t3==1)/sum(t3>1)
sum(t4==1)/sum(t4>1)
sum(t5==1)/sum(t5>1)

#========== percentage profit you would have made if you had bet on each horse every time they race
(sum(t1==1)*mean(cr[cr$horse=="Annie Power (IRE)",c("PercentageOdds")]))-(sum(t1>1)*mean(cr[cr$horse=="Annie Power (IRE)",c("PercentageOdds")]))
(sum(t2==1)*mean(cr[cr$horse=="Glens Melody (IRE)",c("PercentageOdds")]))-(sum(t2>1)*mean(cr[cr$horse=="Glens Melody (IRE)",c("PercentageOdds")]))
(sum(t3==1)*mean(cr[cr$horse=="Hurricane Fly (IRE)",c("PercentageOdds")]))-(sum(t3>1)*mean(cr[cr$horse=="Hurricane Fly (IRE)",c("PercentageOdds")]))
(sum(t4==1)*mean(cr[cr$horse=="Jezki (IRE)",c("PercentageOdds")]))-(sum(t4>1)*mean(cr[cr$horse=="Jezki (IRE)",c("PercentageOdds")]))
(sum(t5==1)*mean(cr[cr$horse=="Rebel Fitz (FR)",c("PercentageOdds")]))-(sum(t5>1)*mean(cr[cr$horse=="Rebel Fitz (FR)",c("PercentageOdds")]))

#========== additional code to display data for presentation

#question 2
cr[1:10, c("horse", "Behind", "Winner.Race.Time", "Time.in.secs")]

#question 4
cr[1:10, c("horse","For", "Against", "PercentageOdds")]

#question 5
mean(totalOddsPerRace$Total)-100
summary(totalOddsPerRace)