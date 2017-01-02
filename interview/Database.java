package interview;

/**
 * Created by 1990c on 11/6/2016.
 */
import java.util.*;

public class Database {
  public static class Table {
    private final String name;
    private final String[] columnNames;
    private final List<List<Object>> data;

    public Table(String name, String[] columnNames, List<List<Object>> data) {
      this.name = name;
      this.columnNames = columnNames;
      this.data = data;
    }

    public void insert(Object[] row) {
      data.add(Arrays.asList(row));
    }

    public String getName() {
      return name;
    }

    public String[] getColumnNames() {
      return columnNames;
    }

    public List<List<Object>> getData() {
      return data;
    }

    public Table select(String[] projectedColumnNames) {
      // IMPLEMENT ME
      Table selectTable = new Table("Where", projectedColumnNames, new ArrayList<List<Object>>());
      ArrayList<Integer> colsIndex = new ArrayList<>();
      String[] cols = this.getColumnNames();
      int j = 0;
      for (int i = 0; i < cols.length; i++) {
        if (cols[i].equals(projectedColumnNames[j])) {
          colsIndex.add(i);
          j++;
        }
      }
      for (List<Object> list : this.getData()) {
        Object[] selectData = new Object[colsIndex.size()];
        j = 0;
        for (int i : colsIndex) {
          selectData[j] = list.get(i);
          j++;
        }
        selectTable.insert(selectData);
      }
      return selectTable;
    }

    public Table where(String columnName, Object value) {
      // IMPLEMENT ME
      String[] cols = this.getColumnNames();
      Table whereTable = new Table("Where", cols, new ArrayList<List<Object>>());
      int ind;
      for (ind = 0; ind < cols.length; ind++) {
        if (cols[ind].equals(columnName)) {
          break;
        }
      }
      for (List<Object> list : this.getData()) {
        if (list.get(ind).equals(value)) {
          whereTable.insert(list.toArray());
        }
      }
      return whereTable;
    }

    @Override
    public String toString() {
      StringBuffer sb = new StringBuffer(String.join(", ", columnNames)).append("\n");
      for (List<Object> row : data) {
        if (row.size() != 0) {
          Object value = row.get(0);
          sb.append(value == null ? "" : value.toString());
          for (int i = 1; i < row.size(); i++) {
            value = row.get(i);
            sb.append(", ").append(value == null ? "" : value.toString());
          }
        }
        sb.append("\n");
      }
      return sb.toString();
    }
  }

  private final Map<String, Table> tableMap;

  public Database() {
    this.tableMap = new HashMap<String, Table>();
  }

  public void addTable(Table table) {
    this.tableMap.put(table.getName(), table);
  }

  public Table getTable(String tableName) {
    return tableMap.get(tableName);
  }

  public Table innerJoin(Table leftTable, String leftTableKeyName, Table rightTable, String rightTableKeyName) {
    // IMPLEMENT ME
    String[] colsLeft = leftTable.getColumnNames();
    String[] colsRight = rightTable.getColumnNames();
    Table joinedTable = new Table("InnerJoin", null, null);

    return joinedTable;
  }

  public static void main(String[] args) {
    Table departmentTable = new Table("departments", new String[]{"id", "name"}, new ArrayList<List<Object>>());
    departmentTable.insert(new Object[] {0, "engineering"});
    departmentTable.insert(new Object[] {1, "finance"});

    Table userTable = new Table("users", new String[]{"id", "department_id", "name"}, new ArrayList<List<Object>>());
    userTable.insert(new Object[] {0, 0, "Ian"});
    userTable.insert(new Object[] {1, 0, "John"});
    userTable.insert(new Object[] {2, 1, "Eddie"});
    userTable.insert(new Object[] {3, 1, "Mark"});

    Table salaryTable = new Table("salaries", new String[]{"id", "user_id", "amount"}, new ArrayList<List<Object>>());
    salaryTable.insert(new Object[] {0, 0, 100});
    salaryTable.insert(new Object[] {1, 1, 150});
    salaryTable.insert(new Object[] {2, 1, 200});
    salaryTable.insert(new Object[] {3, 3, 200});
    salaryTable.insert(new Object[] {4, 3, 300});
    salaryTable.insert(new Object[] {5, 4, 400});

    Database db = new Database();
    db.addTable(departmentTable);
    db.addTable(userTable);
    db.addTable(salaryTable);

    // should print
    // id, department_id, name
    // 1, 0, John
    System.out.println(db.getTable("users").where("id", 1).select(new String[] {"id", "department_id", "name"}));

    // should print
    // users.name, departments.name
    // Ian, engineering
    // John, engineering
    System.out.println(
        db.innerJoin(db.getTable("users"), "department_id", db.getTable("departments"), "id")
            .where("departments.name", "engineering")
            .select(new String[]{"users.name", "departments.name"}));
  }
}
