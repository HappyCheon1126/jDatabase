package t9_netpay;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class SBDAO {
    Connection conn =null;
    PreparedStatement pstmt =null;
    ResultSet rs=null;
    
    BonbongVO voB=null;
    SawonVO voS=null;
    String sql="";
    
    
    public SBDAO() {
        String url="jdbc:mysql://localhost:3306/javaProject";
        String user="atom";
        String password="1234";
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(url, user, password);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void connClose() {
        try {
            conn.close();
        } catch (SQLException e) {}
    }
    
    public void pstmtClose() {
        try {
            if(pstmt!=null)pstmt.close();
        } catch (SQLException e) {}
    }
    
    public void rsClose() {
        try {
            if(rs!=null)rs.close();
        } catch (Exception e) {
            pstmtClose();
        }
    }
    
    
    
    //직급 검색용 조회
    public BonbongVO getSearchB(String jikkub){
        BonbongVO vo=new BonbongVO();
        try {
            sql="select * from bonbong where jikkub=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, jikkub);
            rs=pstmt.executeQuery();
            if(rs.next()) {
                vo.setJikkub(rs.getString("jikkub"));
            }
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            pstmtClose();
        }
        
        return vo;
    }
    
    
    // 본봉테이블에 직급별 본봉 입력처리
    public int setInputB(BonbongVO voB) {
        int res=0;
        try {
            sql="insert into bonbong (jikkub,bonbong) values (?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, voB.getJikkub());
            pstmt.setInt(2, voB.getBonbong());
            res=pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            pstmtClose();
        }
        
        return res;
    }
 
    public ArrayList<BonbongVO> getListB() {
        ArrayList<BonbongVO> vos = new ArrayList<BonbongVO>();
        try {
            sql="select * from bonbong order by bonbong desc";
            pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            
            while(rs.next()) {
                voB=new BonbongVO();
                voB.setJikkub(rs.getString("jikkub"));
                voB.setBonbong(rs.getInt("bonbong"));
                vos.add(voB);
            }
            
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            rsClose();
        }
        return vos;
    }
 
    // 본봉테이블에 직급별 본봉 수정처리...
    public int setUpdateB(String jikkub, String newJikkub, int bonbong) {
        int res=0;
        try {
            sql="update bonbong set jikkub=?, bonbong=? where jikkub=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, newJikkub);
            pstmt.setInt(2, bonbong);
            pstmt.setString(3, jikkub);
            res=pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            pstmtClose();
        }
        
        return res;
    }
 
    public int setDeleteB(String jikkub) {
        int res=0;
        try {
            sql="delete from bonbong where jikkub=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, jikkub);
            res=pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            pstmtClose();
        }
        return res;
    }
    
    //////////////////////////여기서부터 사원관리자 출력용/////////////////////////////
 
    public ArrayList<SawonVO> getListS() {
        ArrayList<SawonVO> vos = new ArrayList<SawonVO>();
        try {
            sql="select*from sawon";
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
 
            while(rs.next()) {
                voS=new SawonVO();
                voS.setSabun(rs.getInt("sabun"));
                voS.setName(rs.getString("name"));
                voS.setJikkub(rs.getString("jikkub"));
                voS.setNight(rs.getInt("night"));
                vos.add(voS);
            }
            //직급 비교해서 두개가 같으면 본봉 출력하면 되지않을까
            /*
             이런식이니까
             사원 VO출력 다 하고 사원직급<=>본봉직급 비교로
             직급이 같은 본봉을 출력 (같은배열안에있을테니까)
             */
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            rsClose();
        }
        
        return vos;
    }
    
    
    //개별정보검색
    public SawonVO getSearchS(String name) {
        SawonVO voS= new SawonVO();
        try {
            sql="select*from sawon where name=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, name);
            rs=pstmt.executeQuery();
            if(rs.next()) {
                voS.setSabun(rs.getInt("sabun"));
                voS.setName(rs.getString("name"));
                voS.setJikkub(rs.getString("jikkub"));
                voS.setNight(rs.getInt("night"));
            }
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            rsClose();
        }
        
        return voS;
    }
 
    public int setInputS(SawonVO voS) {
        int res=0;
        try {
            sql="insert into sawon values (default,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, voS.getName());
            pstmt.setString(2, voS.getJikkub());
            pstmt.setInt(3, voS.getNight());
            res=pstmt.executeUpdate();
            
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            pstmtClose();
        }
        return res;
    }
 
    public int setUpdateS(String newName, String jikkub, int night, String name) {
        int res=0;
        try {
            sql="update sawon set name=?,jikkub=?,night=? where name=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, newName);
            pstmt.setString(2, jikkub);
            pstmt.setInt(3, night);
            pstmt.setString(4, name);
            res=pstmt.executeUpdate();
                    
            
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            pstmtClose();
        }
        return res;
    }
 
    public void setDeleteS(String name) {
        try {
            sql="delete from sawon where name=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1, name);
            pstmt.execute();
            
        } catch (SQLException e) {
            System.out.println("SQL오류 : "+e.getMessage());
        } finally {
            pstmtClose();
        }
        
        
    }
    
    
}