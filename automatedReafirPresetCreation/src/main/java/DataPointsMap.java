import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataPointsMap {


/*

   in matlab:

   for index = 1:100 fprintf("List<DataPoint> dataPointsForBaseUnit%d = new ArrayList<>();\n", index); end
   for index = 1:100 fprintf("List<DataPoint> dataPointsForBaseUnitNegative%d = new ArrayList<>();\n", index); end

   >> for index = 1:100 fprintf("dataPointsForBaseUnit%d.add(new DataPoint(%.1f,%.13f));\n", [index*ones(29,1) f' baseUnit*index]'); end


   >> for index = 1:100 fprintf("dataPointsForBaseUnitNegative%d.add(new DataPoint(%.1f,%.13f));\n", [index*ones(29,1) f' baseUnit*-index]'); end


   for index = 1:100 fprintf("dataPointsMap.put(%d, dataPointsForBaseUnit%d);\n", index, index); end
   for index = 1:100 fprintf("dataPointsMap.put(%d, dataPointsForBaseUnitNegative%d);\n", -index, index); end

*/

   public static Map<Integer, List<DataPoint>> get() {

      Map<Integer, List<DataPoint>> dataPointsMap = new HashMap<>();

      dataPointsMap = DataPointsMapChunk1.get(dataPointsMap);
      dataPointsMap = DataPointsMapChunk2.get(dataPointsMap);
      dataPointsMap = DataPointsMapChunk3.get(dataPointsMap);
      dataPointsMap = DataPointsMapChunk4.get(dataPointsMap);
      dataPointsMap = DataPointsMapChunk5.get(dataPointsMap);
      dataPointsMap = DataPointsMapChunk6.get(dataPointsMap);
      dataPointsMap = DataPointsMapChunk7.get(dataPointsMap);
      dataPointsMap = DataPointsMapChunk8.get(dataPointsMap);

      return dataPointsMap;
   }

}
