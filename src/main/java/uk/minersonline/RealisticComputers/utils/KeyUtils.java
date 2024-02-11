package uk.minersonline.RealisticComputers.utils;

import org.lwjgl.glfw.GLFW;
import java.awt.event.KeyEvent;

public class KeyUtils {
	public static int convertKey(int glfwKeyCode) {
		return switch (glfwKeyCode) {
			case GLFW.GLFW_KEY_UNKNOWN -> KeyEvent.VK_UNDEFINED;
			case GLFW.GLFW_KEY_SPACE -> KeyEvent.VK_SPACE;
			case GLFW.GLFW_KEY_APOSTROPHE -> KeyEvent.VK_QUOTE;
			case GLFW.GLFW_KEY_COMMA -> KeyEvent.VK_COMMA;
			case GLFW.GLFW_KEY_MINUS -> KeyEvent.VK_MINUS;
			case GLFW.GLFW_KEY_PERIOD -> KeyEvent.VK_PERIOD;
			case GLFW.GLFW_KEY_SLASH -> KeyEvent.VK_SLASH;
			case GLFW.GLFW_KEY_0 -> KeyEvent.VK_0;
			case GLFW.GLFW_KEY_1 -> KeyEvent.VK_1;
			case GLFW.GLFW_KEY_2 -> KeyEvent.VK_2;
			case GLFW.GLFW_KEY_3 -> KeyEvent.VK_3;
			case GLFW.GLFW_KEY_4 -> KeyEvent.VK_4;
			case GLFW.GLFW_KEY_5 -> KeyEvent.VK_5;
			case GLFW.GLFW_KEY_6 -> KeyEvent.VK_6;
			case GLFW.GLFW_KEY_7 -> KeyEvent.VK_7;
			case GLFW.GLFW_KEY_8 -> KeyEvent.VK_8;
			case GLFW.GLFW_KEY_9 -> KeyEvent.VK_9;
			case GLFW.GLFW_KEY_SEMICOLON -> KeyEvent.VK_SEMICOLON;
			case GLFW.GLFW_KEY_EQUAL, GLFW.GLFW_KEY_KP_EQUAL -> KeyEvent.VK_EQUALS;
			case GLFW.GLFW_KEY_A -> KeyEvent.VK_A;
			case GLFW.GLFW_KEY_B -> KeyEvent.VK_B;
			case GLFW.GLFW_KEY_C -> KeyEvent.VK_C;
			case GLFW.GLFW_KEY_D -> KeyEvent.VK_D;
			case GLFW.GLFW_KEY_E -> KeyEvent.VK_E;
			case GLFW.GLFW_KEY_F -> KeyEvent.VK_F;
			case GLFW.GLFW_KEY_G -> KeyEvent.VK_G;
			case GLFW.GLFW_KEY_H -> KeyEvent.VK_H;
			case GLFW.GLFW_KEY_I -> KeyEvent.VK_I;
			case GLFW.GLFW_KEY_J -> KeyEvent.VK_J;
			case GLFW.GLFW_KEY_K -> KeyEvent.VK_K;
			case GLFW.GLFW_KEY_L -> KeyEvent.VK_L;
			case GLFW.GLFW_KEY_M -> KeyEvent.VK_M;
			case GLFW.GLFW_KEY_N -> KeyEvent.VK_N;
			case GLFW.GLFW_KEY_O -> KeyEvent.VK_O;
			case GLFW.GLFW_KEY_P -> KeyEvent.VK_P;
			case GLFW.GLFW_KEY_Q -> KeyEvent.VK_Q;
			case GLFW.GLFW_KEY_R -> KeyEvent.VK_R;
			case GLFW.GLFW_KEY_S -> KeyEvent.VK_S;
			case GLFW.GLFW_KEY_T -> KeyEvent.VK_T;
			case GLFW.GLFW_KEY_U -> KeyEvent.VK_U;
			case GLFW.GLFW_KEY_V -> KeyEvent.VK_V;
			case GLFW.GLFW_KEY_W -> KeyEvent.VK_W;
			case GLFW.GLFW_KEY_X -> KeyEvent.VK_X;
			case GLFW.GLFW_KEY_Y -> KeyEvent.VK_Y;
			case GLFW.GLFW_KEY_Z -> KeyEvent.VK_Z;
			case GLFW.GLFW_KEY_LEFT_BRACKET -> KeyEvent.VK_OPEN_BRACKET;
			case GLFW.GLFW_KEY_BACKSLASH -> KeyEvent.VK_BACK_SLASH;
			case GLFW.GLFW_KEY_RIGHT_BRACKET -> KeyEvent.VK_CLOSE_BRACKET;
			case GLFW.GLFW_KEY_GRAVE_ACCENT -> KeyEvent.VK_BACK_QUOTE;
			case GLFW.GLFW_KEY_ESCAPE -> KeyEvent.VK_ESCAPE;
			case GLFW.GLFW_KEY_ENTER, GLFW.GLFW_KEY_KP_ENTER -> KeyEvent.VK_ENTER;
			case GLFW.GLFW_KEY_TAB -> KeyEvent.VK_TAB;
			case GLFW.GLFW_KEY_BACKSPACE -> KeyEvent.VK_BACK_SPACE;
			case GLFW.GLFW_KEY_INSERT -> KeyEvent.VK_INSERT;
			case GLFW.GLFW_KEY_DELETE -> KeyEvent.VK_DELETE;
			case GLFW.GLFW_KEY_RIGHT -> KeyEvent.VK_RIGHT;
			case GLFW.GLFW_KEY_LEFT -> KeyEvent.VK_LEFT;
			case GLFW.GLFW_KEY_DOWN -> KeyEvent.VK_DOWN;
			case GLFW.GLFW_KEY_UP -> KeyEvent.VK_UP;
			case GLFW.GLFW_KEY_PAGE_UP -> KeyEvent.VK_PAGE_UP;
			case GLFW.GLFW_KEY_PAGE_DOWN -> KeyEvent.VK_PAGE_DOWN;
			case GLFW.GLFW_KEY_HOME -> KeyEvent.VK_HOME;
			case GLFW.GLFW_KEY_END -> KeyEvent.VK_END;
			case GLFW.GLFW_KEY_CAPS_LOCK -> KeyEvent.VK_CAPS_LOCK;
			case GLFW.GLFW_KEY_SCROLL_LOCK -> KeyEvent.VK_SCROLL_LOCK;
			case GLFW.GLFW_KEY_NUM_LOCK -> KeyEvent.VK_NUM_LOCK;
			case GLFW.GLFW_KEY_PRINT_SCREEN -> KeyEvent.VK_PRINTSCREEN;
			case GLFW.GLFW_KEY_PAUSE -> KeyEvent.VK_PAUSE;
			case GLFW.GLFW_KEY_F1 -> KeyEvent.VK_F1;
			case GLFW.GLFW_KEY_F2 -> KeyEvent.VK_F2;
			case GLFW.GLFW_KEY_F3 -> KeyEvent.VK_F3;
			case GLFW.GLFW_KEY_F4 -> KeyEvent.VK_F4;
			case GLFW.GLFW_KEY_F5 -> KeyEvent.VK_F5;
			case GLFW.GLFW_KEY_F6 -> KeyEvent.VK_F6;
			case GLFW.GLFW_KEY_F7 -> KeyEvent.VK_F7;
			case GLFW.GLFW_KEY_F8 -> KeyEvent.VK_F8;
			case GLFW.GLFW_KEY_F9 -> KeyEvent.VK_F9;
			case GLFW.GLFW_KEY_F10 -> KeyEvent.VK_F10;
			case GLFW.GLFW_KEY_F11 -> KeyEvent.VK_F11;
			case GLFW.GLFW_KEY_F12 -> KeyEvent.VK_F12;
			case GLFW.GLFW_KEY_KP_0 -> KeyEvent.VK_NUMPAD0;
			case GLFW.GLFW_KEY_KP_1 -> KeyEvent.VK_NUMPAD1;
			case GLFW.GLFW_KEY_KP_2 -> KeyEvent.VK_NUMPAD2;
			case GLFW.GLFW_KEY_KP_3 -> KeyEvent.VK_NUMPAD3;
			case GLFW.GLFW_KEY_KP_4 -> KeyEvent.VK_NUMPAD4;
			case GLFW.GLFW_KEY_KP_5 -> KeyEvent.VK_NUMPAD5;
			case GLFW.GLFW_KEY_KP_6 -> KeyEvent.VK_NUMPAD6;
			case GLFW.GLFW_KEY_KP_7 -> KeyEvent.VK_NUMPAD7;
			case GLFW.GLFW_KEY_KP_8 -> KeyEvent.VK_NUMPAD8;
			case GLFW.GLFW_KEY_KP_9 -> KeyEvent.VK_NUMPAD9;
			case GLFW.GLFW_KEY_KP_DECIMAL -> KeyEvent.VK_DECIMAL;
			case GLFW.GLFW_KEY_KP_DIVIDE -> KeyEvent.VK_DIVIDE;
			case GLFW.GLFW_KEY_KP_MULTIPLY -> KeyEvent.VK_MULTIPLY;
			case GLFW.GLFW_KEY_KP_SUBTRACT -> KeyEvent.VK_SUBTRACT;
			case GLFW.GLFW_KEY_KP_ADD -> KeyEvent.VK_ADD;
			case GLFW.GLFW_KEY_LEFT_SHIFT, GLFW.GLFW_KEY_RIGHT_SHIFT -> KeyEvent.VK_SHIFT;
			case GLFW.GLFW_KEY_LEFT_CONTROL, GLFW.GLFW_KEY_RIGHT_CONTROL -> KeyEvent.VK_CONTROL;
			case GLFW.GLFW_KEY_LEFT_ALT -> KeyEvent.VK_ALT;
			case GLFW.GLFW_KEY_LEFT_SUPER, GLFW.GLFW_KEY_RIGHT_SUPER -> KeyEvent.VK_WINDOWS;
			case GLFW.GLFW_KEY_RIGHT_ALT -> KeyEvent.VK_ALT_GRAPH;
			// Add more cases for other keys as needed
			default -> KeyEvent.VK_UNDEFINED;
		};
	}

	public static boolean isCharacterKey(int glfwKeyCode) {
		return switch (glfwKeyCode) {
			case GLFW.GLFW_KEY_UNKNOWN, GLFW.GLFW_KEY_SPACE, GLFW.GLFW_KEY_APOSTROPHE,
					GLFW.GLFW_KEY_COMMA, GLFW.GLFW_KEY_MINUS, GLFW.GLFW_KEY_PERIOD,
					GLFW.GLFW_KEY_SLASH, GLFW.GLFW_KEY_SEMICOLON, GLFW.GLFW_KEY_EQUAL,
					GLFW.GLFW_KEY_A, GLFW.GLFW_KEY_B, GLFW.GLFW_KEY_C, GLFW.GLFW_KEY_D,
					GLFW.GLFW_KEY_E, GLFW.GLFW_KEY_F, GLFW.GLFW_KEY_G, GLFW.GLFW_KEY_H,
					GLFW.GLFW_KEY_I, GLFW.GLFW_KEY_J, GLFW.GLFW_KEY_K, GLFW.GLFW_KEY_L,
					GLFW.GLFW_KEY_M, GLFW.GLFW_KEY_N, GLFW.GLFW_KEY_O, GLFW.GLFW_KEY_P,
					GLFW.GLFW_KEY_Q, GLFW.GLFW_KEY_R, GLFW.GLFW_KEY_S, GLFW.GLFW_KEY_T,
					GLFW.GLFW_KEY_U, GLFW.GLFW_KEY_V, GLFW.GLFW_KEY_W, GLFW.GLFW_KEY_X,
					GLFW.GLFW_KEY_Y, GLFW.GLFW_KEY_Z, GLFW.GLFW_KEY_LEFT_BRACKET,
					GLFW.GLFW_KEY_BACKSLASH, GLFW.GLFW_KEY_RIGHT_BRACKET,
					GLFW.GLFW_KEY_GRAVE_ACCENT, GLFW.GLFW_KEY_WORLD_1,
					GLFW.GLFW_KEY_WORLD_2, GLFW.GLFW_KEY_KP_0, GLFW.GLFW_KEY_KP_1,
					GLFW.GLFW_KEY_KP_2, GLFW.GLFW_KEY_KP_3, GLFW.GLFW_KEY_KP_4,
					GLFW.GLFW_KEY_KP_5, GLFW.GLFW_KEY_KP_6, GLFW.GLFW_KEY_KP_7,
					GLFW.GLFW_KEY_KP_8, GLFW.GLFW_KEY_KP_9, GLFW.GLFW_KEY_KP_DECIMAL,
					GLFW.GLFW_KEY_0, GLFW.GLFW_KEY_1, GLFW.GLFW_KEY_2,
					GLFW.GLFW_KEY_3, GLFW.GLFW_KEY_4, GLFW.GLFW_KEY_5,
					GLFW.GLFW_KEY_6, GLFW.GLFW_KEY_7, GLFW.GLFW_KEY_8, GLFW.GLFW_KEY_9,
					GLFW.GLFW_KEY_KP_DIVIDE, GLFW.GLFW_KEY_KP_MULTIPLY,
					GLFW.GLFW_KEY_KP_SUBTRACT, GLFW.GLFW_KEY_KP_ADD,
					GLFW.GLFW_KEY_KP_ENTER, GLFW.GLFW_KEY_KP_EQUAL -> true;
			default -> false;
		};
	}

	public static char getCharacterFromKeyCode(int glfwKeyCode, boolean shift) {
		char character = switch (glfwKeyCode) {
			case GLFW.GLFW_KEY_A -> shift ? 'A' : 'a';
			case GLFW.GLFW_KEY_B -> shift ? 'B' : 'b';
			case GLFW.GLFW_KEY_C -> shift ? 'C' : 'c';
			case GLFW.GLFW_KEY_D -> shift ? 'D' : 'd';
			case GLFW.GLFW_KEY_E -> shift ? 'E' : 'e';
			case GLFW.GLFW_KEY_F -> shift ? 'F' : 'f';
			case GLFW.GLFW_KEY_G -> shift ? 'G' : 'g';
			case GLFW.GLFW_KEY_H -> shift ? 'H' : 'h';
			case GLFW.GLFW_KEY_I -> shift ? 'I' : 'i';
			case GLFW.GLFW_KEY_J -> shift ? 'J' : 'j';
			case GLFW.GLFW_KEY_K -> shift ? 'K' : 'k';
			case GLFW.GLFW_KEY_L -> shift ? 'L' : 'l';
			case GLFW.GLFW_KEY_M -> shift ? 'M' : 'm';
			case GLFW.GLFW_KEY_N -> shift ? 'N' : 'n';
			case GLFW.GLFW_KEY_O -> shift ? 'O' : 'o';
			case GLFW.GLFW_KEY_P -> shift ? 'P' : 'p';
			case GLFW.GLFW_KEY_Q -> shift ? 'Q' : 'q';
			case GLFW.GLFW_KEY_R -> shift ? 'R' : 'r';
			case GLFW.GLFW_KEY_S -> shift ? 'S' : 's';
			case GLFW.GLFW_KEY_T -> shift ? 'T' : 't';
			case GLFW.GLFW_KEY_U -> shift ? 'U' : 'u';
			case GLFW.GLFW_KEY_V -> shift ? 'V' : 'v';
			case GLFW.GLFW_KEY_W -> shift ? 'W' : 'w';
			case GLFW.GLFW_KEY_X -> shift ? 'X' : 'x';
			case GLFW.GLFW_KEY_Y -> shift ? 'Y' : 'y';
			case GLFW.GLFW_KEY_Z -> shift ? 'Z' : 'z';
			case GLFW.GLFW_KEY_SPACE -> ' ';
			case GLFW.GLFW_KEY_APOSTROPHE -> shift ? '"' : '\'';
			case GLFW.GLFW_KEY_COMMA -> shift ? '<' : ',';
			case GLFW.GLFW_KEY_MINUS -> shift ? '_' : '-';
			case GLFW.GLFW_KEY_PERIOD -> shift ? '>' : '.';
			case GLFW.GLFW_KEY_SLASH -> shift ? '?' : '/';
			case GLFW.GLFW_KEY_SEMICOLON -> shift ? ':' : ';';
			case GLFW.GLFW_KEY_EQUAL -> shift ? '+' : '=';
			case GLFW.GLFW_KEY_LEFT_BRACKET -> shift ? '{' : '[';
			case GLFW.GLFW_KEY_BACKSLASH -> shift ? '|' : '\\';
			case GLFW.GLFW_KEY_RIGHT_BRACKET -> shift ? '}' : ']';
			case GLFW.GLFW_KEY_GRAVE_ACCENT -> shift ? '~' : '`';
			case GLFW.GLFW_KEY_WORLD_1, GLFW.GLFW_KEY_WORLD_2 -> '\0';
			case GLFW.GLFW_KEY_KP_0, GLFW.GLFW_KEY_0 -> '0';
			case GLFW.GLFW_KEY_KP_1, GLFW.GLFW_KEY_1 -> '1';
			case GLFW.GLFW_KEY_KP_2, GLFW.GLFW_KEY_2 -> '2';
			case GLFW.GLFW_KEY_KP_3, GLFW.GLFW_KEY_3 -> '3';
			case GLFW.GLFW_KEY_KP_4, GLFW.GLFW_KEY_4 -> '4';
			case GLFW.GLFW_KEY_KP_5, GLFW.GLFW_KEY_5 -> '5';
			case GLFW.GLFW_KEY_KP_6, GLFW.GLFW_KEY_6 -> '6';
			case GLFW.GLFW_KEY_KP_7, GLFW.GLFW_KEY_7 -> '7';
			case GLFW.GLFW_KEY_KP_8, GLFW.GLFW_KEY_8 -> '8';
			case GLFW.GLFW_KEY_KP_9, GLFW.GLFW_KEY_9 -> '9';
			case GLFW.GLFW_KEY_KP_DECIMAL -> '.';
			case GLFW.GLFW_KEY_KP_DIVIDE -> '/';
			case GLFW.GLFW_KEY_KP_MULTIPLY -> '*';
			case GLFW.GLFW_KEY_KP_SUBTRACT -> '-';
			case GLFW.GLFW_KEY_KP_ADD -> '+';
			case GLFW.GLFW_KEY_KP_ENTER, GLFW.GLFW_KEY_ENTER -> '\n';
			case GLFW.GLFW_KEY_BACKSPACE -> '\b';
			case GLFW.GLFW_KEY_TAB -> '\t';
			default -> '\0';
		};

		return character;
	}

	public static int getModifiers(int glfwModifiers) {
		int awtModifiers = 0;

		if ((glfwModifiers & GLFW.GLFW_MOD_SHIFT) != 0) {
			awtModifiers |= KeyEvent.SHIFT_MASK;
		}
		if ((glfwModifiers & GLFW.GLFW_MOD_CONTROL) != 0) {
			awtModifiers |= KeyEvent.CTRL_MASK;
		}
		if ((glfwModifiers & GLFW.GLFW_MOD_ALT) != 0) {
			awtModifiers |= KeyEvent.ALT_MASK;
		}
		if ((glfwModifiers & GLFW.GLFW_MOD_SUPER) != 0) {
			awtModifiers |= KeyEvent.META_MASK;
		}

		return awtModifiers;
	}
}
