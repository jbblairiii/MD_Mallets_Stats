/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package softballstats;

import java.text.DecimalFormat;

/**
 *
 * @author jb834r
 */
public class Player {
    private String mName;
    private double mGames, mAbs, mRuns, mSingles, mDoubles, mTriples, 
            mHomeruns, mSacs, mWalks, mRbi, mSos, mFos, mGidp;
    private static final DecimalFormat percentage = new DecimalFormat ("#.000");
    public static final String DELIM=" ";

    public Player(String name){
        mName=name;
        mGames=0;
        mAbs=0;
        mRuns=0;
        mSingles=0;
        mDoubles=0;
        mTriples=0;      
        mHomeruns=0;
        mSacs=0;
        mWalks=0;
        mRbi=0;
    }
    

    public Player(String name, double g, double ab, double r, double s, double d, double t,
            double h, double sa, double w, double rb, double so, double fo, double dp){
        mName=name;
        mGames=g;
        mAbs=ab;
        mRuns=r;
        mSingles=s;
        mDoubles=d;
        mTriples=t;      
        mHomeruns=h;
        mSacs=sa;
        mWalks=w;
        mRbi=rb;
        mSos=so;
        mFos=fo;
        mGidp=dp;
    }

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    public double getGames(){
        return mGames;
    }
    
    public void setGames(double mGames){
        this.mGames = mGames;
    }
    
    public double getAbs() {
        return mAbs;
    }

    public void setAbs(double mAbs) {
        this.mAbs = mAbs;
    }

    public double getRuns() {
        return mRuns;
    }

    public void setRuns(double mRuns) {
        this.mRuns = mRuns;
    }

    public double getSingles() {
        return mSingles;
    }

    public void setSingles(double mSingles) {
        this.mSingles = mSingles;
    }

    public double getDoubles() {
        return mDoubles;
    }

    public void setDoubles(double mDoubles) {
        this.mDoubles = mDoubles;
    }

    public double getTriples() {
        return mTriples;
    }

    public void setTriples(double mTriples) {
        this.mTriples = mTriples;
    }

    public double getHomeruns() {
        return mHomeruns;
    }

    public void setHomeruns(double mHomeruns) {
        this.mHomeruns = mHomeruns;
    }

    public double getSacs() {
        return mSacs;
    }

    public void setSacs(double mSacs) {
        this.mSacs = mSacs;
    }

    public double getWalks() {
        return mWalks;
    }

    public void setWalks(double mWalks) {
        this.mWalks = mWalks;
    }

    public double getRbi() {
        return mRbi;
    }

    public void setRbi(double mRbi) {
        this.mRbi = mRbi;
    }

    public double getSos() {
        return mSos;
    }

    public void setSos(double mSos) {
        this.mSos = mSos;
    }

    public double getFos() {
        return mFos;
    }

    public void setFos(double mFos) {
        this.mFos = mFos;
    }

    public double getGidp() {
        return mGidp;
    }

    public void setGidp(double mGidp) {
        this.mGidp = mGidp;
    }
    
    
    
    public double getHits(){
        return mSingles+mDoubles+mTriples+mHomeruns;
    }
    
    public double getAverage(){
        if(mAbs==0)
            return 0;
          
        return getHits()/mAbs;
    }
    
    public double getSlugging(){
        if(mAbs==0)
            return 0;
  
        return (mSingles + (2*mDoubles) + (3*mTriples) + (4*mHomeruns)) / mAbs;
    }
    
    public double getOBP(){
        if(mAbs+mWalks+mSacs == 0)
            return 0;
  
        return (getHits()+mWalks)/(mAbs+mWalks+mSacs);
    }
    
    public String toString(){
        return  mName+DELIM+
                (int)mGames+DELIM+
                (int)mAbs+DELIM+
                (int)mRuns+DELIM+
                (int)getHits()+DELIM+
                (int)mSingles+DELIM+
                (int)mDoubles+DELIM+
                (int)mTriples+DELIM+
                (int)mHomeruns+DELIM+
                (int)mRbi+DELIM+
                (int)mWalks+DELIM+
                (int)mSacs+DELIM+
                (int)mSos+DELIM+
                (int)mFos+DELIM+
                (int)mGidp+DELIM+              
                percentage.format(getAverage())+DELIM+
                percentage.format(getOBP())+DELIM+
                percentage.format(getSlugging())+DELIM+
                percentage.format(getOBP()+getSlugging());               
    }
    
}
