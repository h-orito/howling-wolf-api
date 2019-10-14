package com.ort.dbflute.allcommon;

import java.util.*;

import org.dbflute.exception.ClassificationNotFoundException;
import org.dbflute.jdbc.Classification;
import org.dbflute.jdbc.ClassificationCodeType;
import org.dbflute.jdbc.ClassificationMeta;
import org.dbflute.jdbc.ClassificationUndefinedHandlingType;
import org.dbflute.optional.OptionalThing;
import static org.dbflute.util.DfTypeUtil.emptyStrings;

/**
 * The definition of classification.
 * @author DBFlute(AutoGenerator)
 */
public interface CDef extends Classification {

    /**
     * 権限
     */
    public enum Authority implements CDef {
        /** 管理者 */
        管理者("ROLE_ADMIN", "管理者", emptyStrings())
        ,
        /** プレイヤー */
        プレイヤー("ROLE_PLAYER", "プレイヤー", emptyStrings())
        ;
        private static final Map<String, Authority> _codeClsMap = new HashMap<String, Authority>();
        private static final Map<String, Authority> _nameClsMap = new HashMap<String, Authority>();
        static {
            for (Authority value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Authority(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Authority; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Authority> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Authority) { return OptionalThing.of((Authority)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Authority> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Authority codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Authority) { return (Authority)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Authority nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Authority> listAll() {
            return new ArrayList<Authority>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<Authority> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Authority." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Authority> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Authority> clsList = new ArrayList<Authority>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Authority> groupOf(String groupName) {
            return new ArrayList<Authority>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 陣営
     */
    public enum Camp implements CDef {
        /** 狐陣営 */
        狐陣営("FOX", "狐陣営", emptyStrings())
        ,
        /** 村人陣営 */
        村人陣営("VILLAGER", "村人陣営", emptyStrings())
        ,
        /** 人狼陣営 */
        人狼陣営("WEREWOLF", "人狼陣営", emptyStrings())
        ;
        private static final Map<String, Camp> _codeClsMap = new HashMap<String, Camp>();
        private static final Map<String, Camp> _nameClsMap = new HashMap<String, Camp>();
        static {
            for (Camp value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Camp(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Camp; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Camp> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Camp) { return OptionalThing.of((Camp)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Camp> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Camp codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Camp) { return (Camp)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Camp nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Camp> listAll() {
            return new ArrayList<Camp>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<Camp> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Camp." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Camp> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Camp> clsList = new ArrayList<Camp>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Camp> groupOf(String groupName) {
            return new ArrayList<Camp>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 村ステータス
     */
    public enum VillageStatus implements CDef {
        /** 廃村 */
        廃村("CANCEL", "廃村", emptyStrings())
        ,
        /** 終了 */
        終了("COMPLETED", "終了", emptyStrings())
        ,
        /** エピローグ */
        エピローグ("EPILOGUE", "エピローグ", emptyStrings())
        ,
        /** 募集中 */
        募集中("IN_PREPARATION", "募集中", emptyStrings())
        ,
        /** 進行中 */
        進行中("IN_PROGRESS", "進行中", emptyStrings())
        ,
        /** 開始待ち */
        開始待ち("WAITING", "開始待ち", emptyStrings())
        ;
        private static final Map<String, VillageStatus> _codeClsMap = new HashMap<String, VillageStatus>();
        private static final Map<String, VillageStatus> _nameClsMap = new HashMap<String, VillageStatus>();
        static {
            for (VillageStatus value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private VillageStatus(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.VillageStatus; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageStatus> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof VillageStatus) { return OptionalThing.of((VillageStatus)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageStatus> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static VillageStatus codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof VillageStatus) { return (VillageStatus)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static VillageStatus nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<VillageStatus> listAll() {
            return new ArrayList<VillageStatus>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<VillageStatus> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: VillageStatus." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<VillageStatus> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<VillageStatus> clsList = new ArrayList<VillageStatus>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<VillageStatus> groupOf(String groupName) {
            return new ArrayList<VillageStatus>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 役職
     */
    public enum Skill implements CDef {
        /** C国狂人 */
        C国狂人("CMADMAN", "C国狂人", emptyStrings())
        ,
        /** 探偵 */
        探偵("DETECTIVE", "探偵", emptyStrings())
        ,
        /** 魔神官 */
        魔神官("EVILMEDIUM", "魔神官", emptyStrings())
        ,
        /** 狂信者 */
        狂信者("FANATIC", "狂信者", emptyStrings())
        ,
        /** おまかせ（足音職） */
        おまかせ足音職("FOOTSTEPS", "おまかせ（足音職）", emptyStrings())
        ,
        /** 妖狐 */
        妖狐("FOX", "妖狐", emptyStrings())
        ,
        /** おまかせ（役職窓あり） */
        おまかせ役職窓あり("FRIENDS", "おまかせ（役職窓あり）", emptyStrings())
        ,
        /** 導師 */
        導師("GURU", "導師", emptyStrings())
        ,
        /** 狩人 */
        狩人("HUNTER", "狩人", emptyStrings())
        ,
        /** おまかせ */
        おまかせ("LEFTOVER", "おまかせ", emptyStrings())
        ,
        /** 狂人 */
        狂人("MADMAN", "狂人", emptyStrings())
        ,
        /** 共鳴者 */
        共鳴者("MASON", "共鳴者", emptyStrings())
        ,
        /** 霊能者 */
        霊能者("MEDIUM", "霊能者", emptyStrings())
        ,
        /** おまかせ（人外） */
        おまかせ人外("NOVILLAGERS", "おまかせ（人外）", emptyStrings())
        ,
        /** 占い師 */
        占い師("SEER", "占い師", emptyStrings())
        ,
        /** 村人 */
        村人("VILLAGER", "村人", emptyStrings())
        ,
        /** おまかせ（村人陣営） */
        おまかせ村人陣営("VILLAGERS", "おまかせ（村人陣営）", emptyStrings())
        ,
        /** 人狼 */
        人狼("WEREWOLF", "人狼", emptyStrings())
        ,
        /** おまかせ（人狼陣営） */
        おまかせ人狼陣営("WEREWOLFS", "おまかせ（人狼陣営）", emptyStrings())
        ,
        /** 賢者 */
        賢者("WISE", "賢者", emptyStrings())
        ;
        private static final Map<String, Skill> _codeClsMap = new HashMap<String, Skill>();
        private static final Map<String, Skill> _nameClsMap = new HashMap<String, Skill>();
        static {
            for (Skill value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Skill(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Skill; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Skill> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Skill) { return OptionalThing.of((Skill)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Skill> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Skill codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Skill) { return (Skill)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Skill nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Skill> listAll() {
            return new ArrayList<Skill>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<Skill> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Skill." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Skill> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Skill> clsList = new ArrayList<Skill>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Skill> groupOf(String groupName) {
            return new ArrayList<Skill>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * メッセージ種別
     */
    public enum MessageType implements CDef {
        /** 村建て発言 */
        村建て発言("CREATOR_SAY", "村建て発言", emptyStrings())
        ,
        /** 死者の呻き */
        死者の呻き("GRAVE_SAY", "死者の呻き", emptyStrings())
        ,
        /** 共鳴発言 */
        共鳴発言("MASON_SAY", "共鳴発言", emptyStrings())
        ,
        /** 独り言 */
        独り言("MONOLOGUE_SAY", "独り言", emptyStrings())
        ,
        /** 通常発言 */
        通常発言("NORMAL_SAY", "通常発言", emptyStrings())
        ,
        /** 役職霊視結果 */
        役職霊視結果("PRIVATE_GURU", "役職霊視結果", emptyStrings())
        ,
        /** 足音調査結果 */
        足音調査結果("PRIVATE_INVESTIGATE", "足音調査結果", emptyStrings())
        ,
        /** 白黒霊視結果 */
        白黒霊視結果("PRIVATE_PSYCHIC", "白黒霊視結果", emptyStrings())
        ,
        /** 白黒占い結果 */
        白黒占い結果("PRIVATE_SEER", "白黒占い結果", emptyStrings())
        ,
        /** 非公開システムメッセージ */
        非公開システムメッセージ("PRIVATE_SYSTEM", "非公開システムメッセージ", emptyStrings())
        ,
        /** 役職占い結果 */
        役職占い結果("PRIVATE_WISE", "役職占い結果", emptyStrings())
        ,
        /** 公開システムメッセージ */
        公開システムメッセージ("PUBLIC_SYSTEM", "公開システムメッセージ", emptyStrings())
        ,
        /** 秘話 */
        秘話("SECRET_SAY", "秘話", emptyStrings())
        ,
        /** 見学発言 */
        見学発言("SPECTATE_SAY", "見学発言", emptyStrings())
        ,
        /** 人狼の囁き */
        人狼の囁き("WEREWOLF_SAY", "人狼の囁き", emptyStrings())
        ;
        private static final Map<String, MessageType> _codeClsMap = new HashMap<String, MessageType>();
        private static final Map<String, MessageType> _nameClsMap = new HashMap<String, MessageType>();
        static {
            for (MessageType value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private MessageType(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.MessageType; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<MessageType> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof MessageType) { return OptionalThing.of((MessageType)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<MessageType> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static MessageType codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof MessageType) { return (MessageType)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static MessageType nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<MessageType> listAll() {
            return new ArrayList<MessageType>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<MessageType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: MessageType." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<MessageType> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<MessageType> clsList = new ArrayList<MessageType>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<MessageType> groupOf(String groupName) {
            return new ArrayList<MessageType>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 死亡理由
     */
    public enum DeadReason implements CDef {
        /** 襲撃 */
        襲撃("ATTACK", "襲撃", emptyStrings())
        ,
        /** 呪殺 */
        呪殺("DIVINED", "呪殺", emptyStrings())
        ,
        /** 処刑 */
        処刑("EXECUTE", "処刑", emptyStrings())
        ,
        /** 突然 */
        突然("SUDDON", "突然", emptyStrings())
        ;
        private static final Map<String, DeadReason> _codeClsMap = new HashMap<String, DeadReason>();
        private static final Map<String, DeadReason> _nameClsMap = new HashMap<String, DeadReason>();
        static {
            for (DeadReason value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private DeadReason(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.DeadReason; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<DeadReason> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof DeadReason) { return OptionalThing.of((DeadReason)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<DeadReason> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static DeadReason codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof DeadReason) { return (DeadReason)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static DeadReason nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<DeadReason> listAll() {
            return new ArrayList<DeadReason>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<DeadReason> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: DeadReason." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<DeadReason> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<DeadReason> clsList = new ArrayList<DeadReason>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<DeadReason> groupOf(String groupName) {
            return new ArrayList<DeadReason>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 能力種別
     */
    public enum AbilityType implements CDef {
        /** 襲撃 */
        襲撃("ATTACK", "襲撃", emptyStrings())
        ,
        /** 占い */
        占い("DIVINE", "占い", emptyStrings())
        ,
        /** 護衛 */
        護衛("GUARD", "護衛", emptyStrings())
        ,
        /** 捜査 */
        捜査("INVESTIGATE", "捜査", emptyStrings())
        ;
        private static final Map<String, AbilityType> _codeClsMap = new HashMap<String, AbilityType>();
        private static final Map<String, AbilityType> _nameClsMap = new HashMap<String, AbilityType>();
        static {
            for (AbilityType value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private AbilityType(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.AbilityType; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<AbilityType> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof AbilityType) { return OptionalThing.of((AbilityType)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<AbilityType> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static AbilityType codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof AbilityType) { return (AbilityType)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static AbilityType nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<AbilityType> listAll() {
            return new ArrayList<AbilityType>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<AbilityType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: AbilityType." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<AbilityType> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<AbilityType> clsList = new ArrayList<AbilityType>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<AbilityType> groupOf(String groupName) {
            return new ArrayList<AbilityType>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 表情種別
     */
    public enum FaceType implements CDef {
        /** 墓下 */
        墓下("GRAVE", "墓下", emptyStrings())
        ,
        /** 共鳴 */
        共鳴("MASON", "共鳴", emptyStrings())
        ,
        /** 独り言 */
        独り言("MONOLOGUE", "独り言", emptyStrings())
        ,
        /** 通常 */
        通常("NORMAL", "通常", emptyStrings())
        ,
        /** 秘話 */
        秘話("SECRET", "秘話", emptyStrings())
        ,
        /** 囁き */
        囁き("WEREWOLF", "囁き", emptyStrings())
        ;
        private static final Map<String, FaceType> _codeClsMap = new HashMap<String, FaceType>();
        private static final Map<String, FaceType> _nameClsMap = new HashMap<String, FaceType>();
        static {
            for (FaceType value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private FaceType(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.FaceType; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<FaceType> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof FaceType) { return OptionalThing.of((FaceType)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<FaceType> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static FaceType codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof FaceType) { return (FaceType)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static FaceType nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<FaceType> listAll() {
            return new ArrayList<FaceType>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<FaceType> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: FaceType." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<FaceType> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<FaceType> clsList = new ArrayList<FaceType>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<FaceType> groupOf(String groupName) {
            return new ArrayList<FaceType>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 村設定項目
     */
    public enum VillageSettingItem implements CDef {
        /** キャラクターグループID */
        キャラクターグループid("character_group_id", "キャラクターグループID", emptyStrings())
        ,
        /** 更新間隔秒 */
        更新間隔秒("day_change_interval_seconds", "更新間隔秒", emptyStrings())
        ,
        /** ダミーキャラID */
        ダミーキャラid("dummy_chara_id", "ダミーキャラID", emptyStrings())
        ,
        /** コミット可能か */
        コミット可能か("is_available_commit", "コミット可能か", emptyStrings())
        ,
        /** 役職希望可能か */
        役職希望可能か("is_available_skill_request", "役職希望可能か", emptyStrings())
        ,
        /** 見学可能か */
        見学可能か("is_available_spectate", "見学可能か", emptyStrings())
        ,
        /** 突然死ありか */
        突然死ありか("is_available_suddenly_death", "突然死ありか", emptyStrings())
        ,
        /** 墓下役職公開ありか */
        墓下役職公開ありか("is_open_skill_in_grave", "墓下役職公開ありか", emptyStrings())
        ,
        /** 記名投票か */
        記名投票か("is_open_vote", "記名投票か", emptyStrings())
        ,
        /** 墓下見学発言を生存者が見られるか */
        墓下見学発言を生存者が見られるか("is_visible_grave_message", "墓下見学発言を生存者が見られるか", emptyStrings())
        ,
        /** 入村パスワード */
        入村パスワード("join_password", "入村パスワード", emptyStrings())
        ,
        /** 構成 */
        構成("organize", "構成", emptyStrings())
        ,
        /** 最大人数 */
        最大人数("person_max", "最大人数", emptyStrings())
        ,
        /** 最低人数 */
        最低人数("person_min", "最低人数", emptyStrings())
        ,
        /** 開始予定日時 */
        開始予定日時("start_datetime", "開始予定日時", emptyStrings())
        ,
        /** 期間形式 */
        期間形式("term_type", "期間形式", emptyStrings())
        ;
        private static final Map<String, VillageSettingItem> _codeClsMap = new HashMap<String, VillageSettingItem>();
        private static final Map<String, VillageSettingItem> _nameClsMap = new HashMap<String, VillageSettingItem>();
        static {
            for (VillageSettingItem value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private VillageSettingItem(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.VillageSettingItem; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageSettingItem> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof VillageSettingItem) { return OptionalThing.of((VillageSettingItem)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<VillageSettingItem> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static VillageSettingItem codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof VillageSettingItem) { return (VillageSettingItem)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static VillageSettingItem nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<VillageSettingItem> listAll() {
            return new ArrayList<VillageSettingItem>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<VillageSettingItem> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: VillageSettingItem." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<VillageSettingItem> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<VillageSettingItem> clsList = new ArrayList<VillageSettingItem>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<VillageSettingItem> groupOf(String groupName) {
            return new ArrayList<VillageSettingItem>(4);
        }

        @Override public String toString() { return code(); }
    }

    /**
     * 期間
     */
    public enum Term implements CDef {
        /** 長期: 長期人狼 */
        長期("LONG", "長期", emptyStrings())
        ,
        /** 短期: 短期人狼 */
        短期("SHORT", "短期", emptyStrings())
        ;
        private static final Map<String, Term> _codeClsMap = new HashMap<String, Term>();
        private static final Map<String, Term> _nameClsMap = new HashMap<String, Term>();
        static {
            for (Term value : values()) {
                _codeClsMap.put(value.code().toLowerCase(), value);
                for (String sister : value.sisterSet()) { _codeClsMap.put(sister.toLowerCase(), value); }
                _nameClsMap.put(value.name().toLowerCase(), value);
            }
        }
        private String _code; private String _alias; private Set<String> _sisterSet;
        private Term(String code, String alias, String[] sisters)
        { _code = code; _alias = alias; _sisterSet = Collections.unmodifiableSet(new LinkedHashSet<String>(Arrays.asList(sisters))); }
        public String code() { return _code; } public String alias() { return _alias; }
        public Set<String> sisterSet() { return _sisterSet; }
        public Map<String, Object> subItemMap() { return Collections.emptyMap(); }
        public ClassificationMeta meta() { return CDef.DefMeta.Term; }

        public boolean inGroup(String groupName) {
            return false;
        }

        /**
         * Get the classification of the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns empty)
         * @return The optional classification corresponding to the code. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Term> of(Object code) {
            if (code == null) { return OptionalThing.ofNullable(null, () -> { throw new ClassificationNotFoundException("null code specified"); }); }
            if (code instanceof Term) { return OptionalThing.of((Term)code); }
            if (code instanceof OptionalThing<?>) { return of(((OptionalThing<?>)code).orElse(null)); }
            return OptionalThing.ofNullable(_codeClsMap.get(code.toString().toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification code: " + code);
            });
        }

        /**
         * Find the classification by the name. (CaseInsensitive)
         * @param name The string of name, which is case-insensitive. (NotNull)
         * @return The optional classification corresponding to the name. (NotNull, EmptyAllowed: if not found, returns empty)
         */
        public static OptionalThing<Term> byName(String name) {
            if (name == null) { throw new IllegalArgumentException("The argument 'name' should not be null."); }
            return OptionalThing.ofNullable(_nameClsMap.get(name.toLowerCase()), () ->{
                throw new ClassificationNotFoundException("Unknown classification name: " + name);
            });
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use of(code).</span> <br>
         * Get the classification by the code. (CaseInsensitive)
         * @param code The value of code, which is case-insensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the code. (NullAllowed: if not found, returns null)
         */
        public static Term codeOf(Object code) {
            if (code == null) { return null; }
            if (code instanceof Term) { return (Term)code; }
            return _codeClsMap.get(code.toString().toLowerCase());
        }

        /**
         * <span style="color: #AD4747; font-size: 120%">Old style so use byName(name).</span> <br>
         * Get the classification by the name (also called 'value' in ENUM world).
         * @param name The string of name, which is case-sensitive. (NullAllowed: if null, returns null)
         * @return The instance of the corresponding classification to the name. (NullAllowed: if not found, returns null)
         */
        public static Term nameOf(String name) {
            if (name == null) { return null; }
            try { return valueOf(name); } catch (RuntimeException ignored) { return null; }
        }

        /**
         * Get the list of all classification elements. (returns new copied list)
         * @return The snapshot list of all classification elements. (NotNull)
         */
        public static List<Term> listAll() {
            return new ArrayList<Term>(Arrays.asList(values()));
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if not found, throws exception)
         */
        public static List<Term> listByGroup(String groupName) {
            if (groupName == null) { throw new IllegalArgumentException("The argument 'groupName' should not be null."); }
            throw new ClassificationNotFoundException("Unknown classification group: Term." + groupName);
        }

        /**
         * Get the list of classification elements corresponding to the specified codes. (returns new copied list) <br>
         * @param codeList The list of plain code, which is case-insensitive. (NotNull)
         * @return The snapshot list of classification elements in the code list. (NotNull, EmptyAllowed: when empty specified)
         */
        public static List<Term> listOf(Collection<String> codeList) {
            if (codeList == null) { throw new IllegalArgumentException("The argument 'codeList' should not be null."); }
            List<Term> clsList = new ArrayList<Term>(codeList.size());
            for (String code : codeList) { clsList.add(of(code).get()); }
            return clsList;
        }

        /**
         * Get the list of classification elements in the specified group. (returns new copied list) <br>
         * @param groupName The string of group name, which is case-sensitive. (NullAllowed: if null, returns empty list)
         * @return The snapshot list of classification elements in the group. (NotNull, EmptyAllowed: if the group is not found)
         */
        public static List<Term> groupOf(String groupName) {
            return new ArrayList<Term>(4);
        }

        @Override public String toString() { return code(); }
    }

    public enum DefMeta implements ClassificationMeta {
        /** 権限 */
        Authority
        ,
        /** 陣営 */
        Camp
        ,
        /** 村ステータス */
        VillageStatus
        ,
        /** 役職 */
        Skill
        ,
        /** メッセージ種別 */
        MessageType
        ,
        /** 死亡理由 */
        DeadReason
        ,
        /** 能力種別 */
        AbilityType
        ,
        /** 表情種別 */
        FaceType
        ,
        /** 村設定項目 */
        VillageSettingItem
        ,
        /** 期間 */
        Term
        ;
        public String classificationName() {
            return name(); // same as definition name
        }

        public OptionalThing<? extends Classification> of(Object code) {
            if (Authority.name().equals(name())) { return CDef.Authority.of(code); }
            if (Camp.name().equals(name())) { return CDef.Camp.of(code); }
            if (VillageStatus.name().equals(name())) { return CDef.VillageStatus.of(code); }
            if (Skill.name().equals(name())) { return CDef.Skill.of(code); }
            if (MessageType.name().equals(name())) { return CDef.MessageType.of(code); }
            if (DeadReason.name().equals(name())) { return CDef.DeadReason.of(code); }
            if (AbilityType.name().equals(name())) { return CDef.AbilityType.of(code); }
            if (FaceType.name().equals(name())) { return CDef.FaceType.of(code); }
            if (VillageSettingItem.name().equals(name())) { return CDef.VillageSettingItem.of(code); }
            if (Term.name().equals(name())) { return CDef.Term.of(code); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public OptionalThing<? extends Classification> byName(String name) {
            if (Authority.name().equals(name())) { return CDef.Authority.byName(name); }
            if (Camp.name().equals(name())) { return CDef.Camp.byName(name); }
            if (VillageStatus.name().equals(name())) { return CDef.VillageStatus.byName(name); }
            if (Skill.name().equals(name())) { return CDef.Skill.byName(name); }
            if (MessageType.name().equals(name())) { return CDef.MessageType.byName(name); }
            if (DeadReason.name().equals(name())) { return CDef.DeadReason.byName(name); }
            if (AbilityType.name().equals(name())) { return CDef.AbilityType.byName(name); }
            if (FaceType.name().equals(name())) { return CDef.FaceType.byName(name); }
            if (VillageSettingItem.name().equals(name())) { return CDef.VillageSettingItem.byName(name); }
            if (Term.name().equals(name())) { return CDef.Term.byName(name); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public Classification codeOf(Object code) { // null if not found, old style so use classificationOf(code)
            if (Authority.name().equals(name())) { return CDef.Authority.codeOf(code); }
            if (Camp.name().equals(name())) { return CDef.Camp.codeOf(code); }
            if (VillageStatus.name().equals(name())) { return CDef.VillageStatus.codeOf(code); }
            if (Skill.name().equals(name())) { return CDef.Skill.codeOf(code); }
            if (MessageType.name().equals(name())) { return CDef.MessageType.codeOf(code); }
            if (DeadReason.name().equals(name())) { return CDef.DeadReason.codeOf(code); }
            if (AbilityType.name().equals(name())) { return CDef.AbilityType.codeOf(code); }
            if (FaceType.name().equals(name())) { return CDef.FaceType.codeOf(code); }
            if (VillageSettingItem.name().equals(name())) { return CDef.VillageSettingItem.codeOf(code); }
            if (Term.name().equals(name())) { return CDef.Term.codeOf(code); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public Classification nameOf(String name) { // null if not found, old style so use classificationByName(name)
            if (Authority.name().equals(name())) { return CDef.Authority.valueOf(name); }
            if (Camp.name().equals(name())) { return CDef.Camp.valueOf(name); }
            if (VillageStatus.name().equals(name())) { return CDef.VillageStatus.valueOf(name); }
            if (Skill.name().equals(name())) { return CDef.Skill.valueOf(name); }
            if (MessageType.name().equals(name())) { return CDef.MessageType.valueOf(name); }
            if (DeadReason.name().equals(name())) { return CDef.DeadReason.valueOf(name); }
            if (AbilityType.name().equals(name())) { return CDef.AbilityType.valueOf(name); }
            if (FaceType.name().equals(name())) { return CDef.FaceType.valueOf(name); }
            if (VillageSettingItem.name().equals(name())) { return CDef.VillageSettingItem.valueOf(name); }
            if (Term.name().equals(name())) { return CDef.Term.valueOf(name); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> listAll() {
            if (Authority.name().equals(name())) { return toClsList(CDef.Authority.listAll()); }
            if (Camp.name().equals(name())) { return toClsList(CDef.Camp.listAll()); }
            if (VillageStatus.name().equals(name())) { return toClsList(CDef.VillageStatus.listAll()); }
            if (Skill.name().equals(name())) { return toClsList(CDef.Skill.listAll()); }
            if (MessageType.name().equals(name())) { return toClsList(CDef.MessageType.listAll()); }
            if (DeadReason.name().equals(name())) { return toClsList(CDef.DeadReason.listAll()); }
            if (AbilityType.name().equals(name())) { return toClsList(CDef.AbilityType.listAll()); }
            if (FaceType.name().equals(name())) { return toClsList(CDef.FaceType.listAll()); }
            if (VillageSettingItem.name().equals(name())) { return toClsList(CDef.VillageSettingItem.listAll()); }
            if (Term.name().equals(name())) { return toClsList(CDef.Term.listAll()); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> listByGroup(String groupName) { // exception if not found
            if (Authority.name().equals(name())) { return toClsList(CDef.Authority.listByGroup(groupName)); }
            if (Camp.name().equals(name())) { return toClsList(CDef.Camp.listByGroup(groupName)); }
            if (VillageStatus.name().equals(name())) { return toClsList(CDef.VillageStatus.listByGroup(groupName)); }
            if (Skill.name().equals(name())) { return toClsList(CDef.Skill.listByGroup(groupName)); }
            if (MessageType.name().equals(name())) { return toClsList(CDef.MessageType.listByGroup(groupName)); }
            if (DeadReason.name().equals(name())) { return toClsList(CDef.DeadReason.listByGroup(groupName)); }
            if (AbilityType.name().equals(name())) { return toClsList(CDef.AbilityType.listByGroup(groupName)); }
            if (FaceType.name().equals(name())) { return toClsList(CDef.FaceType.listByGroup(groupName)); }
            if (VillageSettingItem.name().equals(name())) { return toClsList(CDef.VillageSettingItem.listByGroup(groupName)); }
            if (Term.name().equals(name())) { return toClsList(CDef.Term.listByGroup(groupName)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> listOf(Collection<String> codeList) {
            if (Authority.name().equals(name())) { return toClsList(CDef.Authority.listOf(codeList)); }
            if (Camp.name().equals(name())) { return toClsList(CDef.Camp.listOf(codeList)); }
            if (VillageStatus.name().equals(name())) { return toClsList(CDef.VillageStatus.listOf(codeList)); }
            if (Skill.name().equals(name())) { return toClsList(CDef.Skill.listOf(codeList)); }
            if (MessageType.name().equals(name())) { return toClsList(CDef.MessageType.listOf(codeList)); }
            if (DeadReason.name().equals(name())) { return toClsList(CDef.DeadReason.listOf(codeList)); }
            if (AbilityType.name().equals(name())) { return toClsList(CDef.AbilityType.listOf(codeList)); }
            if (FaceType.name().equals(name())) { return toClsList(CDef.FaceType.listOf(codeList)); }
            if (VillageSettingItem.name().equals(name())) { return toClsList(CDef.VillageSettingItem.listOf(codeList)); }
            if (Term.name().equals(name())) { return toClsList(CDef.Term.listOf(codeList)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        public List<Classification> groupOf(String groupName) { // old style
            if (Authority.name().equals(name())) { return toClsList(CDef.Authority.groupOf(groupName)); }
            if (Camp.name().equals(name())) { return toClsList(CDef.Camp.groupOf(groupName)); }
            if (VillageStatus.name().equals(name())) { return toClsList(CDef.VillageStatus.groupOf(groupName)); }
            if (Skill.name().equals(name())) { return toClsList(CDef.Skill.groupOf(groupName)); }
            if (MessageType.name().equals(name())) { return toClsList(CDef.MessageType.groupOf(groupName)); }
            if (DeadReason.name().equals(name())) { return toClsList(CDef.DeadReason.groupOf(groupName)); }
            if (AbilityType.name().equals(name())) { return toClsList(CDef.AbilityType.groupOf(groupName)); }
            if (FaceType.name().equals(name())) { return toClsList(CDef.FaceType.groupOf(groupName)); }
            if (VillageSettingItem.name().equals(name())) { return toClsList(CDef.VillageSettingItem.groupOf(groupName)); }
            if (Term.name().equals(name())) { return toClsList(CDef.Term.groupOf(groupName)); }
            throw new IllegalStateException("Unknown definition: " + this); // basically unreachable
        }

        @SuppressWarnings("unchecked")
        private List<Classification> toClsList(List<?> clsList) {
            return (List<Classification>)clsList;
        }

        public ClassificationCodeType codeType() {
            if (Authority.name().equals(name())) { return ClassificationCodeType.String; }
            if (Camp.name().equals(name())) { return ClassificationCodeType.String; }
            if (VillageStatus.name().equals(name())) { return ClassificationCodeType.String; }
            if (Skill.name().equals(name())) { return ClassificationCodeType.String; }
            if (MessageType.name().equals(name())) { return ClassificationCodeType.String; }
            if (DeadReason.name().equals(name())) { return ClassificationCodeType.String; }
            if (AbilityType.name().equals(name())) { return ClassificationCodeType.String; }
            if (FaceType.name().equals(name())) { return ClassificationCodeType.String; }
            if (VillageSettingItem.name().equals(name())) { return ClassificationCodeType.String; }
            if (Term.name().equals(name())) { return ClassificationCodeType.String; }
            return ClassificationCodeType.String; // as default
        }

        public ClassificationUndefinedHandlingType undefinedHandlingType() {
            if (Authority.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (Camp.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (VillageStatus.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (Skill.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (MessageType.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (DeadReason.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (AbilityType.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (FaceType.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (VillageSettingItem.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            if (Term.name().equals(name())) { return ClassificationUndefinedHandlingType.LOGGING; }
            return ClassificationUndefinedHandlingType.LOGGING; // as default
        }

        public static OptionalThing<CDef.DefMeta> find(String classificationName) { // instead of valueOf()
            if (classificationName == null) { throw new IllegalArgumentException("The argument 'classificationName' should not be null."); }
            if (Authority.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Authority); }
            if (Camp.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Camp); }
            if (VillageStatus.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.VillageStatus); }
            if (Skill.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Skill); }
            if (MessageType.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.MessageType); }
            if (DeadReason.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.DeadReason); }
            if (AbilityType.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.AbilityType); }
            if (FaceType.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.FaceType); }
            if (VillageSettingItem.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.VillageSettingItem); }
            if (Term.name().equalsIgnoreCase(classificationName)) { return OptionalThing.of(CDef.DefMeta.Term); }
            return OptionalThing.ofNullable(null, () -> {
                throw new ClassificationNotFoundException("Unknown classification: " + classificationName);
            });
        }

        public static CDef.DefMeta meta(String classificationName) { // old style so use find(name)
            if (classificationName == null) { throw new IllegalArgumentException("The argument 'classificationName' should not be null."); }
            if (Authority.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Authority; }
            if (Camp.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Camp; }
            if (VillageStatus.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.VillageStatus; }
            if (Skill.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Skill; }
            if (MessageType.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.MessageType; }
            if (DeadReason.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.DeadReason; }
            if (AbilityType.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.AbilityType; }
            if (FaceType.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.FaceType; }
            if (VillageSettingItem.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.VillageSettingItem; }
            if (Term.name().equalsIgnoreCase(classificationName)) { return CDef.DefMeta.Term; }
            throw new IllegalStateException("Unknown classification: " + classificationName);
        }

        @SuppressWarnings("unused")
        private String[] xinternalEmptyString() {
            return emptyStrings(); // to suppress 'unused' warning of import statement
        }
    }
}
